New York Times
A simple app to hit the NY Times Most Popular Articles API and show a list of articles,
That shows details when items on the list are tapped (a typical master/detail app).
Getting Started
Prerequisites
•	Android Studio must be installed.
•	See https://developer.nytimes.com/ for details of APIs exposed by The New York Times.
Documentation
Parameters:
“all-sections” for the section path component in the URL above and 7 for period (available period values are 1, 7 and 30, which represents how far back, in days, the API returns results for).
Sample-key could be found via registering a user on API console of “The New York Times”.
Example:
http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?apikey=sample-key
On parsing the response from api, user will be able to get the list of all most viewed articles and user can select any article to view details.
 
Build Dependencies
•	   androidTestImplementation 'com.android.support.test:runner:1.0.1'
•	   androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
•	    //
•	    compile 'com.squareup.okhttp3:logging-interceptor:3.8.0'
•	    annotationProcessor 'com.google.dagger:dagger-compiler:2.0'
•	    compile 'com.google.dagger:dagger:2.2'
•	    compile 'com.squareup.retrofit2:retrofit:2.3.0'
•	    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
•	    compile 'com.squareup.okhttp3:okhttp:3.8.0'
•	    compile 'com.google.code.gson:gson:2.6.2'
•	    compile 'com.squareup.retrofit2:converter-gson:2.0.1'
•	    compile 'io.reactivex:rxandroid:1.2.1'
•	    compile 'io.reactivex:rxjava:1.1.6'
•	    provided 'javax.annotation:jsr250-api:1.0'
•	    //
•	    compile 'com.github.bumptech.glide:glide:3.8.0'
•	    testCompile 'org.mockito:mockito-core:1.10.19'
•	    testCompile 'org.powermock:powermock-core:1.6.4'
•	    testCompile 'org.powermock:powermock-api-mockito:1.6.4'
•	    testCompile 'org.powermock:powermock-module-junit4:1.6.4'
•	    androidTestCompile 'junit:junit:4.12'
Versioning
1.0
