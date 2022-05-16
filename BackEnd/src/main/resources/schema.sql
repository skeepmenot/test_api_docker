CREATE TABLE IF NOT EXISTS public.todolist
(
    id                 uuid         DEFAULT gen_random_uuid()   NOT NULL  CONSTRAINT todo PRIMARY KEY,
    topic              varchar(150) DEFAULT ''    NOT NULL,
    description        varchar(300) DEFAULT ''    NOT NULL,
    is_check           boolean      DEFAULT false NOT NULL,
    created_timestamp  timestamptz  DEFAULT now() NOT NULL,
    modified_timestamp timestamptz  DEFAULT now() NOT NULL
    );

CREATE UNIQUE INDEX IF NOT EXISTS todolist_id_uindex ON public.todolist (id);