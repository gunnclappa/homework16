# Проект по автоматизации тестирования Market.kz

## :bookmark_tabs: Содержание

* <a href="#stack">Cтек технологий</a>
* <a href="#object">Реализованные проверки</a>
* <a href="#console">Команды запуска тестов</a>
* <a href="#screenshot">Скриншоты и видео</a>

  + <a href="#ijjs">InteliJ IDEA, Java, JUnit 5, Selenide</a>
  + <a href="#selenoid">Selenoid</a>
  + <a href="#gradle">Gradle</a>
  + <a href="#jenkins">Jenkins</a>
  + <a href="#allure">Allure</a>
  + <a href="#telegram">Telegram</a>

<a id="stack"></a>
## :hammer_and_wrench: Cтек технологий
<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="external/logos/Intelij_IDEA.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="external/logos/Java.svg" width="50"/></a>
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="external/logos/JUnit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="external/logos/Selenide.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="external/logos/Gradle.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure" height="50" src="external/logos/Allure.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="external/logos/Jenkins.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="external/logos/Selenoid.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="external/logos/GitHub.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="external/logos/Telegram.svg" width="50"/></a>
</div>

<a id="object"></a>
## :mag: Реализованные проверки
- ✓ Проверка поиска объявлений
- ✓ Проверка открытия категории "Путешествия"
- ✓ Проверка открытия сайта "Krisha.kz"
- ✓ Проверка отображения бесплатных объявлений
- ✓ Проверка существования категории "Смарт-часы"

<a id="console"></a>
## :computer: Команды запуска тестов
```bash
gradle clean 
test
-Dbrowser=${BROWSER}
-DwindowSize=${WINDOW_SIZE} 
-DremoteWebDriver=${REMOTE_DRIVER}
```
> `${BROWSER}` - браузер [ *firefox* , *chrome* <sub>(default)</sub> ]
>
> `${WINDOW_SIZE}` - размер окна браузера [ *1024x768* , *1366x768* <sub>(default)</sub> , *1366x768* ]
>
> `${REMOTE_DRIVER}` - подключение удаленного браузера для тестов [ *false* , *true* <sub>(default)</sub> ]

<a id="selenoid"></a>
#### <a href="https://selenoid.autotests.cloud/video/4a544544d069a501ee461083c9babb79.mp4"><img alt="Selenoid" height="50" src="external/logos/Selenoid.svg" width="50"/>Selenoid</a>
> *Прогон ресурсоемких автотестов на удаленном сервере*

<video src="https://user-images.githubusercontent.com/110110734/193814550-cef6ecdb-f702-4fa5-a6cf-4cf6cc523097.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Selenoid.svg">
Видео не доступно для этого браузера
</video>

<a id="gradle"></a>
#### <a href="https://gradle.org/"><img alt="Gradle" height="50" src="external/logos/Gradle.svg" width="50"/>Gradle</a>
> *Автоматическая сборка проекта и управление зависимостями*

```groovy
plugins {
    id 'java'
    id 'io.qameta.allure' version '2.10.0'
}

def allureVersion = '2.19.0'

allure {
    report {
        version.set(allureVersion)
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set(allureVersion)
            }
        }
    }
}

repositories {
    mavenCentral()
}

compileJava {
    options.encoding = 'UTF-8'
}
compileTestJava {
    options.encoding = 'UTF-8'
}

dependencies {
    testImplementation('org.junit.jupiter:junit-jupiter:5.9.0',
            'com.codeborne:selenide:6.7.4',
            'io.qameta.allure:allure-selenide:2.19.0',
            'org.slf4j:slf4j-simple:2.0.1')
}

tasks.withType(Test) {
    systemProperties(System.getProperties())
    useJUnitPlatform()

    testLogging {
        lifecycle {
            events "started", "skipped", "failed", "standard_error", "standard_out"
            exceptionFormat "short"
        }
    }
}

test {
    useJUnitPlatform()
}
```

<a id="jenkins"></a>
####  <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/"><img alt="Jenkins" height="50" src="external/logos/Jenkins.svg" width="50"/>Jenkins</a>
> *Решение комплекса задач по сборке проекта, прогону автотестов, получению отчетов и отправке уведомлений по результатам сборки*

  
<a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/">

<img src="https://user-images.githubusercontent.com/110110734/193813994-88c78b62-b6d9-4d00-ac2a-d7eae8e491b7.png" alt="Jenkins">
</a>

<a id="allure"></a>
#### <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure//"><img alt="Allure" height="50" src="external/logos/Allure.svg" width="50"/>Allure</a>
> *Формирование сводного отчета по результам автотестов*

<table>
    <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/">
        <img src="https://user-images.githubusercontent.com/110110734/193815548-9ba63976-7543-438d-b4aa-51fea0db888e.png">
        </a>
        </td>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/#suites/ef54aae4465c6d48b51f0d82b2bbde21/238f0e3250120aee/">
        <img src="https://user-images.githubusercontent.com/110110734/193815656-d60c090e-77ba-4f08-b4bb-d3860e2976a3.png">
        </a>
        </td>
    </tr>
        <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/#suites/ef54aae4465c6d48b51f0d82b2bbde21/238f0e3250120aee/">
        <img src="https://user-images.githubusercontent.com/110110734/193815846-f7c8675e-ae5c-44b4-a451-a66a32037746.png">
        </a>
        </td>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/#suites/ef54aae4465c6d48b51f0d82b2bbde21/e86211dfbb768d26/">
        <img src="https://user-images.githubusercontent.com/110110734/193815857-a19d8da8-d07f-4e2a-a4f4-893eae213dbf.png">
        </a>
        </td>
    </tr>
</table>

<a id="telegram"></a>
#### <a href="https://t.me/MarketKzNotificationBot"><img alt="Telegram" height="50" src="external/logos/Telegram.svg" width="50"/>Telegram</a>
> *Оперативное предоставление информации о результатах прогона автотестов*

![Telegram screenshot](https://user-images.githubusercontent.com/110110734/193813963-0e4ec16a-b6d3-45d3-bf0d-dc90eb689380.png)
