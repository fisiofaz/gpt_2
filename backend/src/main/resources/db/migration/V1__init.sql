-- Primeira migração do GTP

CREATE TABLE IF NOT EXISTS system_info
(
    id SERIAL PRIMARY KEY,
    version VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO system_info(version)
VALUES ('1.0.0');