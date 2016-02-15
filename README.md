# SpringHibernateTest
 Web приложение, которое позволяет загрузить на сервер Excel файл и добавляет данные из файла в БД
 
# Использованные технологии
  - Spring MVC
  - Spring Boot
  - Hibernate
  - PostgreSql
  - Tomcat
  - Bootstrap
 
# Требования к входным данным
 Excel файл должен содержать один лист с четырьмя колонками:
  - Код - целое число
  - Наименование - строка
  - Цена - число с плавающей запятой
  - Дата - дата и время
 
 Поддерживаемые форматы Excel
  - Microsoft Excel (.xlsx)
  - Microsoft Excel 97/2000/XP (.xls)
 
 Пример входных данных: ProductTestData.xls

# Запуск

java -jar SpringHibernateTest-0.0.1-SNAPSHOT.jar 

--spring.datasource.username=[postgres user]

--spring.datasource.password=[postgres user password]

Доступ к приложению http://localhost:8080
 
 
