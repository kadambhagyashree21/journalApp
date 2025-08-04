CREATE TABLE `journal_entry`.`users` (
`user_id` SERIAL PRIMARY KEY,
 `username` varchar(255) NOT NULL,
 `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `journal_entry`.`journals` (
`id` SERIAL PRIMARY KEY,
 `title` varchar(255) NOT NULL,
 `content` varchar(255) NOT NULL,
 `created_dt` datetime NOT NULL,
 `user_id` bigint(20) unsigned NOT NULL,
 CONSTRAINT `JE_USERS__FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_roles (
    user_id bigint(20) unsigned NOT NULL,
    role VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
