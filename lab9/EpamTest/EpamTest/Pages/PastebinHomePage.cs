using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EpamTest.Pages
{
    internal class PastebinHomePage
    {
        private const string URL = "https://pastebin.com";

        private readonly By _sendButton = By.XPath("//button[@class='btn -big']");
        private readonly By _mainTextArea = By.XPath("//textarea[@id='postform-text']");
        private readonly By _titleInput = By.XPath("//input[@id='postform-name']");
        private readonly By _tenMinOptions = By.XPath("//li[text()='10 Minutes']");
        private readonly By _listSpan = By.Id(("select2-postform-expiration-container"));


        private IWebDriver _driver;
        public  PastebinHomePage openPage()
        {
            _driver.Navigate().GoToUrl(URL);
            return this;

        }
        public PastebinHomePage writeTextToArea(string text)
        {
            _driver.FindElement(_mainTextArea).SendKeys(text);
            return this;
        }

        public PastebinHomePage writeTitle(string text)
        {
            _driver.FindElement(_titleInput).SendKeys(text);
            return this;
        }
        public PastebinHomePage selectOptionsByXPath(string xpath)
        {

            _driver.FindElement(_listSpan).Click();
            _driver.FindElement(By.XPath(xpath)).Click();
            return this;
        }
        public PastebinHomePage createPaste(string text)
        {
            _driver.FindElement(_sendButton).Click();
            return this;
        }

        public PastebinHomePage()
        {
            _driver = new ChromeDriver("D:\\univ\\5 sem\\Test\\lab5");
        }
    }
}
