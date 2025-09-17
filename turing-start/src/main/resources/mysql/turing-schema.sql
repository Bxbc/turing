CREATE TABLE IF NOT EXISTS turing_memory (
    `conversation_id` VARCHAR(36) NOT NULL COMMENT '会话id',
    `gmt_create` TIMESTAMP NOT NULL,
    `content` TEXT NOT NULL,
    `type` ENUM('USER', 'ASSISTANT', 'SYSTEM', 'TOOL') NOT NULL,

    INDEX `cid_time_idx` (`conversation_id`, `gmt_create`)
);
