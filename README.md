# Projeto final da disciplina DM110 - Desenvolvimento JavaEE
## Pós Graduação em Desenvolvimento de Aplicações para Dispositivos Móveis - INATEL

### Banco de dados
```
create table ipstatus (
    ip varchar(20) not null,
    status varchar(15) not null
);

create sequence seq_ip_status;
```

### Endpoints
`[GET] {http://host}/ip-status/api/poller/start/{ip}/{mask}`

`[GET] {http://host}/ip-status/api/poller/status/{ip}`
