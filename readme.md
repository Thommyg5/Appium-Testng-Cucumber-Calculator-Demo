# Appium-TestNG-Cucumber-Calculator-Demo
This is a repository to get testers familiar with using Appium to test mobile applications.
It tests the [Elegant_Calculator](https://github.com/ritik2410/Elegant_Calculator) 
application that was created by user [ritik2410](https://github.com/ritik2410).
The original repository does not necessarily need to be cloned since the Calculator.apk
file has been added inside the resources folder for convenience, but it might be good for
testers to clone this repository to get a feel for the application and Android Studio.

The [startup.md](startup.md)
can be used to not only teach testers how to install all the necessary software to run the tests in this 
project, but can also be used to teach them how to get started on their own projects.

<hr/>

### Technology Used:

- Java
- Appium 
- TestNG
- Cucumber/Gherkin
- Selenium WebDriver
<hr/>

## Why Appium?
Normally when we are testing a web application, we use the Selenium Webdriver. However, 
we cannot use Selenium Webdriver on its own to test mobile applications. For this reason, we have to use 
Appium. Appium is built on top of Selenium which is why we still need to add this dependency to our projects.
The [Appium Server GUI](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4) is used to connect
our testing software to the emulator that is running the application. When testing web applcations, we don't
need this kind of software because Selenium WebDriver takes care of it for us. 

<hr/>

## Future update

You will notice that there is additional code in the [Runner](src/test/java/com/testing/runners/Runner.java)
class that has the @*Method(enabled = false) annotation. These methods are able to programmatically start the
Appium Server and Android emulator and then close them after the test is complete. Start-up instructions will
be updated shortly in order to familiarize testers with completely automating their mobile testing.