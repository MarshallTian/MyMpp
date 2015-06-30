FE_OUTPUT_DIR = /home/code/MyMpp/fe/
BE_OUTPUT_DIR = /home/code/MyMpp/
SRC_FILES = FileObjects.thrift \
			Service.thrift
default:
	for file in $(SRC_FILES); \
	do \
		thrift --gen java -o ${FE_OUTPUT_DIR} $$file;\
		thrift --gen cpp -o ${BE_OUTPUT_DIR} $$file;\
	done
