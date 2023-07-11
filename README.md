# Cервис просмотра ленты статей пациентом
## Приложения
- [x] [REST API с Spring Boot](http://172.16.132.94:3000/students-2023-3-2/back/src/branch/main/right-code-rest-service).
- [ ] [Web-Service с Apache Cxf](http://172.16.132.94:3000/students-2023-3-2/back/src/branch/main/right-code-web-service).

## End-point's REST API
### Получить список статей
- [x] GET /articles/ 
* Сортировка реализована не обязательными параметрами:
- header - заголовок
- pubDate - дата начала публикации
- pubEndDate - дата окончания публикации
- status - статус. Статусы: Опубликована, Черновик, Архивная, Удалена
- tags - тэги
### Получить статью по id
- [x] GET - /articles/{id}
### Получить список главных статей
- [x] GET - /articles/main 
### Создать статью
- [x] POST - /articles/
### Изменить параметры статьи
- [x] PUT - /articles/ 
### Удалить статью.
- [x] DELETE - /articles/ 