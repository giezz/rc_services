# Cервис просмотра ленты статей пациентом
## Приложения
- [x] [REST API с Spring Boot](http://172.16.132.94:3000/students-2023-3-2/back/src/branch/main/right-code-rest-service).
- [ ] [Web-Service с Apache Cxf](http://172.16.132.94:3000/students-2023-3-2/back/src/branch/main/right-code-web-service).

### End-point's REST API

- [x] GET /articles/ - Получить список статей
Сортировка реализована не обязательными параметрами:
- header - заголовок
- pubDate - дата начала публикации
- pubEndDate - дата окончания публикации
- status - статусу. Статусы: Опубликована, Черновик, Архивная, Удалена
- tags - тэги
- [x] GET /articles/{id} - Получить статью по id
- [x] GET /articles/main - Получить главные статьи 
- [x] POST /articles/ - Создать статью
- [x] PUT /articles/ - Изменить статью
- [x] DELETE /articles/ - Удалить статью (изменить статус статьи на "Удалена")