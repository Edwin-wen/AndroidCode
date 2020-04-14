#!/usr/bin/python3
# -*- coding: UTF-8 -*-
from bs4 import BeautifulSoup
from urllib.request import urlopen, Request

lineBreak = "\n"
SIMPLE_NETURL = 'https://leetcode-cn.com/problemset/all/?difficulty=%E7%AE%80%E5%8D%95'
headers = {
    'authority': 'leetcode-cn.com',
    'cache-control': 'max-age=0',
    'upgrade-insecure-requests': '1',
    'user-agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36',
    'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
    'sec-fetch-site': 'same-origin',
    'sec-fetch-mode': 'navigate',
    'sec-fetch-user': '?1',
    'sec-fetch-dest': 'document',
    'referer': 'https://www.google.com/',
    'accept-language': 'zh-CN,zh;q=0.9',
    'cookie': '_uab_collina=158685038217777322746336; gr_user_id=2ac3ff8c-93e6-4062-9817-dbd7d0a02bba; a2873925c34ecbd2_gr_session_id=ecf7422b-8b74-4f28-9da2-181a6092f5f6; grwng_uid=dd13ed15-7c6d-46ab-8a1c-441d1ac93f25; a2873925c34ecbd2_gr_session_id_ecf7422b-8b74-4f28-9da2-181a6092f5f6=true; __asc=e524e12217177a74632a1eee89e; __auc=e524e12217177a74632a1eee89e; _ga=GA1.2.1636110934.1586850384; _gid=GA1.2.1108587815.1586850384; csrftoken=5CEWR5VIOQIKWJVh4PLY3zL2XXTMzdjzQOrv3Wm3ZOTJTX4n3LlvVxcgpK11Pzig; Hm_lvt_fa218a3ff7179639febdb15e372f411c=1586850382,1586850391,1586850395,1586850627; Hm_lpvt_fa218a3ff7179639febdb15e372f411c=1586850627',
}

params = (
    ('difficulty', '\u7B80\u5355'),
)

def print2File(filename, content):
    file = open(filename + ".txt", "w")
    file.write(content)
    file.close()


def getRequest(neturl):
    urlRequest = Request(neturl, headers=headers)
    contents = urlopen(urlRequest)
    result = contents.read().decode('utf-8')
    print2File("QuestionPage", result)
    return contents

def getResponse(page):
    soup = BeautifulSoup(page, "html.parser")
    QuestionList = "题目有：" + lineBreak;
    for tag in soup.find_all('span', class_='data-original-title'):
        QuestionList = QuestionList + tag + lineBreak
    return QuestionList



def printSimple2File():
    request = getRequest(SIMPLE_NETURL)
    result = getResponse(request)
    print2File("SimpleQuest", result)

def printMid2File():
    request = getRequest(SIMPLE_NETURL)
    result = getResponse(request)
    print2File("SimpleQuest", result)

if __name__ == '__main__':
    printSimple2File()

