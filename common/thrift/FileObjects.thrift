namespace cpp MyMpp
namespace java MyMpp.thrift

enum THdfsFileFormat {
	TEXT,
}

struct THdfsFileBlock {
	1: required i64 offset

	2: required i64 length

	3: required list<i32> replica_host_idxs

	4: optional list<i32> disk_ids
}

struct THdfsFileDesc {
	1: required string file_name

	2: required i64 length

	3: required i64 last_modification_time

	4: required list<THdfsFileBlock> file_blocks
}
