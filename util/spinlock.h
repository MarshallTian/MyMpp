/* 
 * File:   spinlock.h
 * Author: root
 *
 * Created on June 23, 2015, 7:55 PM
 */

#ifndef SPINLOCK_H
#define	SPINLOCK_H

#include "common/atomic.h"

#define DCHECK(condition) assert(condition)

namespace MyMpp {

    class SpinLock {
    public:
        SpinLock() : locked_(false) {}
        
        void Lock() {
            while(true) {
                if (__sync_bool_compare_and_swap(&locked_, false, true)) return;
                for (int i = 0; i < NUM_SPIN_CYCLES + 1; ++i) 
                    AtomicUtil::CpuWait();
                if (__sync_bool_compare_and_swap(&locked_, false, true)) return;
                sched_yield();
            }
        }
        
        void Unlock() {
            __sync_synchronize();
            DCHECK(locked_);
            locked_ = false;
        }
        
    private:
        static const int NUM_SPIN_CYCLES = 70;
        
        bool locked_;
    };
    
    class ScopedSpinLock {
    public:
        ScopedSpinLock(SpinLock* lock) {
            lock_ = lock;
            lock->Lock();
        }
        
        ~ScopedSpinLock() {
            lock_->Unlock();
        }
        
    private:
        // Disable copy constructor and assignment
        ScopedSpinLock(const ScopedSpinLock& counter);
        ScopedSpinLock& operator=(const ScopedSpinLock& counter);

        SpinLock* lock_;
    };
}



#endif	/* SPINLOCK_H */

