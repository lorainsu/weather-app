# -*- coding:utf-8 -*-
# ! /usr/bin/python
import testlink
import os

os.environ['TESTLINK_API_PYTHON_SERVER_URL'] = "http://testlinkhttp-service/lib/api/xmlrpc/v1/xmlrpc.php"


class SubmitTestLinkForShowCase():

    def SubmitResultToTestLink(self, testcaseid, testplanid, user, buildname, result, note, testlinkAPI,
                               platformid='0'):
        os.environ['TESTLINK_API_PYTHON_DEVKEY'] = testlinkAPI
        self.testcaseid = testcaseid
        self.testplanid = testplanid
        self.buildname = buildname
        self.result = result
        self.note = note
        self.user = user
        self.platformid = platformid

        tls = testlink.TestLinkHelper().connect(testlink.TestlinkAPIClient)

        tls.reportTCResult(testcaseid=self.testcaseid, testplanid=self.testplanid, buildname=self.buildname,
                           status=self.result,
                           notes=self.note)


if __name__ == "__main__":
    a = SubmitResult()
    a.SubmitResultToTestLink(testcaseid='70', testplanid='73', user='Jenkins', buildname='', result='p',
                             note='fusion stage cpe', testlinkAPI="", platformid='0')

