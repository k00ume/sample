#!/usr/bin/env python3
import time
import selenium
from selenium import webdriver

def edgeDriver():
    options = webdriver.EdgeOptions()
    options.add_argument("--disable-blink-features=AutomationControlled")
    options.add_experimental_option("excludeSwitches", ["enable-automation"])
    options.add_experimental_option("excludeSwitches", ["enable-logging"])

    driver = webdriver.Edge(options=options)
    driver.set_page_load_timeout(30)
    return driver

def exec(driver):
    driver.get('https://www.google.com/')
    print('--- executed ---')

def main():
    driver = edgeDriver()
    exec(driver)
    time.sleep(10)
    driver.quit()

if __name__ == "__main__":
    main()
