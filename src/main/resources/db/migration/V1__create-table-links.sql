CREATE TABLE links (
    id          BIGSERIAL       PRIMARY KEY,
    original_url VARCHAR(2048)  NOT NULL,
    short_key   VARCHAR(10)     NOT NULL UNIQUE,
    created_at  TIMESTAMP       NOT NULL DEFAULT NOW(),
    expires_at  TIMESTAMP,
    click_count BIGINT          NOT NULL DEFAULT 0
);
