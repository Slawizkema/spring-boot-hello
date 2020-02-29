create table task_list (
  id bigserial not null,
  name text not null,
  primary key (id)
);

create table task (
  id bigserial not null,
  description text not null,
  task_priority text not null,
  task_list_id bigint not null references task_list (id),
  parent_task_id bigint references task (id),
  correct boolean not null,
  primary key (id)
);