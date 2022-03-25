Feature: Verify the dashboard page


Scenario Outline: TC001_verify whether the data is populated as expected in Dashboard for the specific date

Given Go to <URL>
When enter the usename as <uname> and password as <password>
Then click sign_in button
Then navigate to <Dashboardpage>
When click the time option
Then select month as <from_month_year> and date as <from_date> from dropdown
Then select the from_time as <from_time> and seconds as <from_seconds>
Then select month as <to_month_year> and date as <to_date> to dropdown
Then select the to_time as <to_time> and seconds as <to_seconds>


Examples:
|URL|uname|password|Dashboardpage|from_month_year|from_date|from_time|from_seconds|to_month_year|to_date|to_time|to_seconds|
|https://reference-test.intellisense.io/|menna+testproject@intellisense.io|AutMaNewTest1#|https://reference-test.intellisense.io/#!/id/dashboards/1471|Nov2020|2|11|35|Feb2022|14|12|35|


Scenario Outline: TC002_verify the Dashboard page icons

Given Go to <URL>
When enter the usename as <uname> and password as <password>
Then click sign_in button
Then navigate to <Dashboardpage>
When click the homepage icon
Then click Cancel option in the dashboard window
When click the duplicate dashboard icon
Then click Cancel option in the duplicate dashboard window
When click the download icon
Then download the files


Examples:
|URL|uname|password|Dashboardpage|
|https://reference-test.intellisense.io/|menna+testproject@intellisense.io|AutMaNewTest1#|https://reference-test.intellisense.io/#!/id/dashboards/1471|


Scenario Outline: TC003_verify the left icons in the Dashboard page

Given Go to <URL>
When enter the usename as <uname> and password as <password>
Then click sign_in button
Then navigate to <Dashboardpage>
When click the dashboard icon
Then check the datas displaying under dashboard icon
When click the thickner icon
When click the flotation icon
When click the pump icon
Then check the datas displaying under pump icon


Examples:
|URL|uname|password|Dashboardpage|
|https://reference-test.intellisense.io/|menna+testproject@intellisense.io|AutMaNewTest1#|https://reference-test.intellisense.io/#!/id/dashboards/1471|


Scenario Outline: TC004_verify the options in dashboard page

Given Go to <URL>
When enter the usename as <uname> and password as <password>
Then click sign_in button
Then navigate to <Dashboardpage>
Then click the search option
Then verify the notification option
Then change the alert options


Examples:
|URL|uname|password|Dashboardpage|
|https://reference-test.intellisense.io/|menna+testproject@intellisense.io|AutMaNewTest1#|https://reference-test.intellisense.io/#!/id/dashboards/1471|

