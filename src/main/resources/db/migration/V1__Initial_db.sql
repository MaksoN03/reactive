CREATE TABLE users (
                       id bigint generated always as identity primary key not null,
                       firstname varchar(100),
                       lastname varchar(100),
                       email varchar(100),
                       isLoyalCustomer boolean
);
CREATE TABLE tours (
                       id bigint generated always as identity primary key not null,
                       title varchar(100),
                       type varchar(100),
                       price money,
                       isHot boolean
);
CREATE TYPE status AS ENUM ('NEW', 'IN_PROGRESS', 'COMPLETED');
CREATE TABLE bookings (
                          id bigint generated always as identity primary key not null,
                          user_id bigint NOT NULL,
                          tour_id bigint NOT NULL,
                          status status
);
ALTER TABLE bookings
    ADD CONSTRAINT fk_tour_id
        FOREIGN KEY (tour_id) REFERENCES tours(id);
ALTER TABLE bookings
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES "users"(id);