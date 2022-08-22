
<h2 align="center"> Проект по автоматизации тестирования API для сайта REQRES.IN <a target="_blank" href="https://reqres.in/"></a> </h2>

<p align="center">
<img title="ReqresIn" src="images/reqresInLogo.png">
</p>


### :green_book: *Содержание*
- *Технологии и инструменты*
- *Примеры автоматизированных тест кейсов*
- *Сборка в Jenkins*
- *Команды для запуска из терминала*
- *Allure отчёт*
- *Интреграция с Allure TestOps*
- *Интеграция с Jira*
- *Уведомление в Telegram при помощи Alert bot*

____

## :computer: *Технологии и инструменты*

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="images/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://avatars.githubusercontent.com/u/19369327?s=200&v=4"><img src="images/Rest-Assured.svg" width="50" height="50"  alt="Rest-Assured"/></a>  
<a href="https://avatars.githubusercontent.com/u/45949248?s=200&v=4"><img src="images/Lombok.svg" width="50" height="50"  alt="Lombok"/></a>  
<a href="https://www.jenkins.io/"><img src="images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

____

## *Примеры автоматизированных тест кейсов*
- :white_check_mark: Проверка успешной регистрации пользователя
- :white_check_mark: Проверка неуспешной регистрации пользователя
- :white_check_mark: Проверка сортировки данных по годам
- :white_check_mark: Проверка удаления пользователя
- :white_check_mark: Проверка аватара на содержание правильного id и окончания email


____

## <img src="images/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/qa_guru_diplom_API_tests/">**Сборка в Jenkins**</a>
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/qa_guru_diplom_API_tests/"><img src="images/JenkinsJobAPI.png" alt="Jenkins"/></a>  
</p>


____
## :keyboard: *Команды для запуска из терминала*

***Локальный запуск:***
```bash  
gradle clean test
```

***Удалённый запуск через Jenkins:***
```bash  
clean test
```

## <img src="images/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a> *Allure* <a target="_blank" href="https://jenkins.autotests.cloud/job/qa_guru_diplom_API_tests/">*отчёт*</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/Allure_Report_Overview.png">  
</p>  

### *Тест кейсы*

<p align="center">  
<img title="Allure Tests" src="images/Test_cases.png">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/Allure_Charts.png">  
</p>

___

## <img src="images/AllureTestOps.svg" width="25" height="25"  alt="Allure"/></a>*Интеграция с* <a target="_blank" href="https://allure.autotests.cloud/launch/15399/tree/155237?treeId=0">*Allure TestOps*</a>

## *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/Allure_Test_Ops_Dashboard.png">  
</p>  

## *Тест кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="images/Allure_TestOps_Test_Cases.png">  
</p>

___

## <img src="images/Jira.svg" width="25" height="25"  alt="Allure"/></a>*Интеграция с* <a target="_blank" href="https://jira.autotests.cloud/browse/AUTO-1318">Jira</a>

<p align="center">  
<img title="Jira" src="images/Jira_Ticket.png">  
</p>

____
## <img src="images/Telegram.svg" width="25" height="25"  alt="Allure"/></a> *Уведомление в Telegram при помощи Alert bot*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/Telegram_bot.png">  
</p>




