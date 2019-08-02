drop database if exists quarkus_issue_3408;
create database if not exists quarkus_issue_3408 default character set = 'utf8' collate utf8_bin;
use quarkus_issue_3408;
set storage_engine=InnoDB;

create table t_geo_country
(
    country_code char(2)      not null,
    country_name varchar(100) not null,
    primary key (country_code),
    unique (country_name)
);

create table t_geo_state
(
    uuid         char(36)     not null,
    country_code char(2)      not null,
    state_code   varchar(25)  not null,
    state_name   varchar(100) not null,
    primary key (uuid),
    unique (country_code, state_code),
    foreign key (country_code) references t_geo_country (country_code)
        on update cascade
        on delete cascade
);

insert into t_geo_country values ('MY', 'Malaysia');
insert into t_geo_state values ('3a341a7c-dc21-476c-ba31-0bd07f244443', 'MY', 'MY-14', 'Wilayah Persekutuan Kuala Lumpur');
insert into t_geo_state values ('50128f46-71dd-49b0-bf86-d9f4d68a2e76', 'MY', 'MY-15', 'Wilayah Persekutuan Labuan');
insert into t_geo_state values ('5e870a00-0be6-458e-8eef-92631b2d0e8a', 'MY', 'MY-16', 'Wilayah Persekutuan Putrajaya');
insert into t_geo_state values ('b507ace7-41dc-4aa8-99ed-1f2a3b49d369', 'MY', 'MY-01', 'Johor');
insert into t_geo_state values ('d2d59643-4a6b-465a-abec-6c1c04a4cac3', 'MY', 'MY-02', 'Kedah');
insert into t_geo_state values ('19898257-e170-499c-a992-d21fa03469c3', 'MY', 'MY-03', 'Kelantan');
insert into t_geo_state values ('da79ec40-f76c-469e-9f0e-87a1abd7b286', 'MY', 'MY-04', 'Melaka');
insert into t_geo_state values ('9208d88f-2e9e-4d3a-84bb-50894a75a135', 'MY', 'MY-05', 'Negeri Sembilan');
insert into t_geo_state values ('6438b45f-afd5-413a-916d-5da1d9cca822', 'MY', 'MY-06', 'Pahang');
insert into t_geo_state values ('a3c1c7fd-3fa7-4aa4-ab35-9617d1c64b89', 'MY', 'MY-08', 'Perak');
insert into t_geo_state values ('dada5187-dbb1-4c58-a7a0-8e840dd07829', 'MY', 'MY-09', 'Perlis');
insert into t_geo_state values ('bd8cb863-b498-4804-837e-7cbe61ca4b7d', 'MY', 'MY-07', 'Pulau Pinang');
insert into t_geo_state values ('26f846bc-c831-493e-a5b9-5cb94234ebc1', 'MY', 'MY-12', 'Sabah');
insert into t_geo_state values ('11efc7f7-4e9e-4e04-b78f-6472c1c73356', 'MY', 'MY-13', 'Sarawak');
insert into t_geo_state values ('b59338ac-d960-4e3f-ad73-0574fa12afa8', 'MY', 'MY-10', 'Selangor');
insert into t_geo_state values ('b61201b8-26f2-40d4-9956-6bc0bdca64ed', 'MY', 'MY-11', 'Terengganu');
