CREATE TABLE congregations (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    code VARCHAR(20) NOT NULL UNIQUE,

    name VARCHAR(150) NOT NULL,

    address VARCHAR(255),

    city VARCHAR(100),

    state VARCHAR(50),

    zip_code VARCHAR(20),

    country VARCHAR(100),

    circuit VARCHAR(20),

    language VARCHAR(30) NOT NULL,

    status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100)
);