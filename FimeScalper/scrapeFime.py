from bs4 import BeautifulSoup
from datetime import date
import re

folderPath = '17Aug FIME Page'

with open(folderPath+'\ACS _ FSS ACS 2.3 _ FIME.html', 'r') as fimePage:
    fimePageContent = fimePage.read()

soupedpage = BeautifulSoup(fimePageContent, 'html.parser')
testCategory = soupedpage.select('span.test-plan-text, span.test-case-text, mat-icon.tc-icon-close, mat-icon.tc-icon-check')
# for eachSpan in testCategory:
#     print(eachSpan.get_text())

resultFilePath = 'result/fimeResult_'+date.today().strftime('%Y-%m-%d')+'.csv'
with open(resultFilePath, 'w+') as resultFile:
    for eachItem in testCategory:
        if eachItem.get_text() == '2.2.0.11' or eachItem.get_text() == '2.1.0.27':
            continue
        elif 'check' in eachItem.get_text() or 'close' in eachItem.get_text():
            if 'check' in eachItem.get_text():
                resultFile.write(',Success')
            elif 'close' in eachItem.get_text():
                resultFile.write(',Failed')
            else:
                resultFile.write(',ERROR')
        elif eachItem.get_text().startswith('TC'):
            resultFile.write('\n,'+eachItem.get_text())
        else:
            resultFile.write('\n'+eachItem.get_text()+',,')
        
