*** Settings ***
Suite Teardown    Delete All Sessions
Library           Collections
Library           String
Library           ../../../../Libs/RequestsLibrary/RequestsKeywords.py
Library           ../../../../Libs/TestLink/SubmitTestLinkForShowCase.py

*** Variable ***
${result}         -1
${note}           ${EMPTY}

*** Test Cases ***
Get Request Wearher
    [Tags]  get
    Create Session  QueryWeather     ${weather_url}
    ${resp} =   Get Request  QueryWeather  /
    Should Be Equal As Strings   ${resp.status_code}   200
    set Suite variable    ${result}    0
    set Suite variable    ${note}    ${resp.content}

SubmitTestLink
    Run Keyword if    ${result}==0    SubmitResultToTestLink    testcaseid=${internalid}    testplanid=${tplan_id}    user=${user}    buildname=${buildname}
    ...    result=p    note=${note}    testlinkAPI=${testlinkAPI}
    ...    ELSE    SubmitResultToTestLink    testcaseid=${internalid}    testplanid=${tplan_id}    user=${user}    buildname=${buildname}
    ...    result=f    note=${note}    testlinkAPI=${testlinkAPI}

