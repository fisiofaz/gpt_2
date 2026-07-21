CREATE TABLE publishers (

    id UUID PRIMARY KEY,

    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,

    gender VARCHAR(20) NOT NULL,

    birth_date DATE,
    baptism_date DATE,
    join_date DATE,

    phone VARCHAR(20),
    email VARCHAR(120),
    address VARCHAR(255),

    status VARCHAR(20) NOT NULL,

    congregation_id UUID NOT NULL,

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,

    created_by VARCHAR(100),
    updated_by VARCHAR(100),

    CONSTRAINT fk_publishers_congregation
    	FOREIGN KEY (congregation_id)
    	REFERENCES congregations(id)
);