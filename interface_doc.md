# 1. User Accounts
/user/info

Param:
username: [String] or email: [String]
password: [String]

Return:
```
{
    avatarUrl: [String],
    username: [String],
    email: [String],
    password: [String],
    displayName: [String],
    bio: [String],
    phone: [String],
    isEmailVerified: [Int],
    isPhoneVerified: [Int],
    posts: [
        postId: [Int],
    ]
}

```

# 2. Post List
/post/list

# 3. Post details
/post/info

# 4. Sign up
/user/signup

Param:
username: [String]
email: [String]
password: [String]

Return:
```
    status: [Int]  -- 0 failed 1 succeed
```

# 5. Publish post

# Console interface
## Approve post
Description:
Change post's status from 2(suspend) to 1(active)

Param:
postId: [Int],

Return:
```
    status: [Int] -- 0 failed 1 succeed
```

# Database (mysql)

~~~

CREATE DATABASE IF NOT EXISTS forumdb;

USE forumdb;

DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
	`id` bigint unsigned NOT NULL AUTO_INCREMENT,
	`avatar_url` varchar(512),
	`username` varchar(32)  NOT NULL,
	`email` varchar(255)  NOT NULL,
	`password` varchar(255) NOT NULL,
	`display_name` varchar(64),
	`bio` text,
	`phone` varchar(32),
	
	`is_email_verified`  tinyint(1) not null default 0,
    `is_phone_verified`  tinyint(1) not null default 0,
    
    `role` tinyint NOT NULL DEFAULT 1,  -- 1=USER,2=ADMIN
    `status` tinyint NOT NULL DEFAULT 1,   -- 1=ACTIVE,2=SUSPENDED,3=DELETED
    
    `last_login_time` int unsigned NOT NULL,
    
    `create_time` int unsigned NOT NULL,
	`update_time` int unsigned NOT NULL,
	`delete_time` int unsigned,
    
	`is_deleted` tinyint unsigned NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='users';

create table `posts` (
    `id`           BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `author_id`    BIGINT UNSIGNED NOT NULL,             -- users(id)
    `title`       VARCHAR(200)    NOT NULL,
    `content_md`   MEDIUMTEXT      NOT NULL,
    `reply_num`    INT UNSIGNED    NOT NULL DEFAULT '0',
    `like_num`    INT UNSIGNED    NOT NULL DEFAULT '0',
    `seen_num`     INT UNSIGNED    NOT NULL DEFAULT '0',
    `create_time` int unsigned NOT NULL,
    `update_time` int unsigned NOT NULL,
    `delete_time` int unsigned,
    `status` tinyint NOT NULL DEFAULT 1,   -- 1=ACTIVE,2=SUSPENDED,3=DELETED,
    `is_deleted` tinyint unsigned NOT NULL DEFAULT '0'

) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='posts';

create table `comments` (
    `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `author_id` BIGINT UNSIGNED NOT NULL,       -- users(id)
    `post_id` BIGINT UNSIGNED NOT NULL,       -- posts(id)
    `content` text NOT NULL,
    `like_num` INT UNSIGNED NOT NULL DEFAULT '0',    
    `create_time` int unsigned NOT NULL,
    `update_time` int unsigned NOT NULL,
    `delete_time` int unsigned,
    `status` tinyint NOT NULL DEFAULT 1,   -- 1=ACTIVE,2=SUSPENDED,3=DELETED,
    `is_deleted` tinyint unsigned NOT NULL DEFAULT '0'
    
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='comments'

~~~

Test data
~~~


INSERT INTO `users` 
(`avatar_url`, `username`, `email`, `password`, `display_name`, `bio`, `phone`,
 `is_email_verified`, `is_phone_verified`, `role`, `status`, 
 `last_login_time`, `create_time`, `update_time`, `delete_time`, `is_deleted`)
VALUES
('https://example.com/avatar/alice.png', 'alice', 'alice@example.com', '$2y$10$abcd1234hashAlice', 'Alice Zhang', 'Love coding and coffee ☕', '+1-202-555-0111',
 1, 0, 1, 1, UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), NULL, 0),

('https://example.com/avatar/bob.png', 'bob', 'bob@example.com', '$2y$10$efgh5678hashBob', 'Bobby Lee', 'Backend developer, Go & Rust enthusiast', '+1-202-555-0222',
 1, 1, 2, 1, UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), NULL, 0),

('https://example.com/avatar/carol.png', 'carol', 'carol@example.com', '$2y$10$ijkl9012hashCarol', 'Carol Wu', 'Frontend designer, Vue & React', '+1-202-555-0333',
 0, 0, 1, 2, UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), NULL, 0),

('https://example.com/avatar/david.png', 'david', 'david@example.com', '$2y$10$mnop3456hashDavid', 'David Kim', 'Mobile developer, Flutter & Swift', '+1-202-555-0444',
 1, 1, 1, 3, UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), 1);

~~~