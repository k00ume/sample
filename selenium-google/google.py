#!/usr/bin/env python3
import time
import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

def edgeDriver():
    options = webdriver.EdgeOptions()
    options.add_argument("--disable-blink-features=AutomationControlled")
    options.add_experimental_option("excludeSwitches", ["enable-automation", "enable-logging"])

    driver = webdriver.Edge(options)
    driver.set_page_load_timeout(30)
    return driver

def exec(driver):
    driver.get('https://www.google.com/')
    driver.find_element(By.ID, "APjFqb").send_keys("selenium")
    driver.find_elements(By.NAME, "btnK")[1].click()
    print('--- executed ---')

def main():
    driver = edgeDriver()
    exec(driver)
    time.sleep(10)
    driver.quit()

if __name__ == "__main__":
    main()
