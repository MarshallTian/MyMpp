/* 
 * File:   internal-queue.h
 * Author: root
 *
 * Created on June 23, 2015, 8:10 PM
 */

#ifndef INTERNAL_QUEUE_H
#define	INTERNAL_QUEUE_H

#include "common/atomic.h";
#include "util/spinlock.h";

namespace MyMpp {
    template<typename T>
    class InternalQueue {
    public:
        struct Node {
        public:
            Node(): parent_queue(NULL), next(NULL), prev(NULL) {}
            virtual ~Node() {}
            
            T* Next() const {
                ScopedSpinLock lock(&parent_queue->lock_);
                return reinterpret_cast<T*>(next);
            }
            
            T* Prev() const {
                ScopedSpinLock lock(&parent_queue->lock_);
                return reinterpret_cast<T*>(prev);
            }
            
        private:
            friend class InternalQueue;
            
            InternalQueue* parent_queue;
            Node* next;
            Node* prev;
        };
        
        InternalQueue() : head_(NULL), tail_(NULL), size_(0) {}
        
        bool empty() const { return head_ == NULL; }
        int size() const { return size_; }
        
        T* head() const {
            ScopedSpinLock lock(&lock_);
            if (empty()) return NULL;
            return reinterpret_cast<T*>(head_);
        }
        
        T* tail() const {
            ScopedSpinLock lock(&lock_);
            if (empty()) return NULL;
            return reinterpret_cast<T*>(tail_);
        }
        
        void Enqueue(T* n) {
            Node* node = (Node*)n;
            DCHECK(node->next == NULL);
            DCHECK(node->prev == NULL);
            DCHECK(node->parent_queue == NULL);
            node->parent_queue = this;
            {
                ScopedSpinLock lock(&lock_);
                if (tail_ != NULL) tail_->next = node;
                node->prev = tail_;
                tail_ = node;
                if (head_ == NULL) head_ = node;
                ++size_;
            }
        }
        
        T* Dequeue() {
            Node *result = NULL;
            {
               ScopedSpinLock lock(&lock_);
               if (empty()) return NULL;
               --size_;
               result = head_;
               head_ = head_->next;
               if (head_ == NULL) {
                   tail_ = NULL;
               } else 
                   head_->prev = NULL;
            }
            
            DCHECK(result != NULL)
            result->next = result->prev = NULL;
            result->parent_queue = NULL;
            return reinterpret_cast<T*>(result);
        }
        
        T* PopBack() {
            Node* result = NULL;
            {
                ScopedSpinLock lock(&lock_);
                if (empty()) return NULL;
                --size_;
                result = tail_;
                tail_ = tail_->prev;
                if (tail_ == NULL) {
                    head_ = NULL;
                } else
                    tail_->next = NULL;
            }
            
            DCHECK(result != NULL)
            result->next = result->prev = NULL;
            result->parent_queue = NULL;
            return reinterpret_cast<T*>(result);
        }
        
        void Remove(T* n) {
            Node *node = (Node *) n;
            if (node->parent_queue == NULL) return;
            DCHECK(node->parent_queue == this);
            {
                ScopedSpinLock lock(&lock_);
                if (node->prev == NULL && node->next == NULL)
                {
                    head_ = tail_ = NULL;
                    --size_;
                    node->parent_queue = NULL;
                    return;
                }
                if (node == head_) {
                    head_ = head_->next;
                } else {
                    node->prev->next = node->next;
                }
                
                if (node == tail_) {
                    tail_ = tail_->prev;
                } else {
                    node->next->prev = node->prev;
                }
                --size_;
            }
            
            node->next = NULL;
            node->prev = NULL;
            node->parent_queue = NULL;
        }
        
        void Clear() {
            ScopedSpinLock lock(&lock_);
            Node *curr = head_;
            while (curr != NULL) {
                Node *tmp = curr;
                curr = curr->next;
                tmp->prev = tmp->next = NULL;
                tmp->parent_queue = NULL;
            }
            size_ = 0;
            head_ = tail_ = 0;
        }
        
        bool Contains(const T* target) const {
            return target->parent_queue == this;
        }
        
        
        
    private:
        friend struct Node;
        mutable SpinLock lock_;
        Node* head_, *tail_;
        int size_;
    };
}


#endif	/* INTERNAL_QUEUE_H */

