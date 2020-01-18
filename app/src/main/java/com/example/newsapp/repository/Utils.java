package com.example.newsapp.repository;

import android.widget.Toast;

import com.example.newsapp.NewsApp;
import com.example.newsapp.repository.model.NewsResponse;
import com.google.gson.Gson;

public class Utils {

    public static void showToastMessage(String message) {
        Toast.makeText(NewsApp.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static NewsResponse getNewsResponse(){
        NewsResponse newsResponse;
        Gson gson = new Gson();
        newsResponse = gson.fromJson(getNewsJson(), NewsResponse.class);

        return newsResponse;
    }

    public static String getNewsJson(){
        return "{\n" +
                "    \"status\": \"ok\",\n" +
                "    \"totalResults\": 38,\n" +
                "    \"articles\": [\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Nj.com\"\n" +
                "            },\n" +
                "            \"author\": \"Jeff Goldman | NJ Advance Media for NJ.com\",\n" +
                "            \"title\": \"N.J. weather: Up to 4 inches of snow in forecast for winter storm. Latest update on timing, snow totals. - NJ.com\",\n" +
                "            \"description\": \"The National Weather Service has issued a winter weather advisory for nine of the state’s 21 counties expected to get 2 to 4 inches of snow.\",\n" +
                "            \"url\": \"https://www.nj.com/weather/2020/01/nj-weather-up-to-4-inches-of-snow-in-forecast-for-winter-storm-latest-update-on-timing-snow-totals.html\",\n" +
                "            \"urlToImage\": \"https://www.nj.com/resizer/Z_oWH-sODEuEdnHgIKDMmUMote0=/1280x0/filters:focal(386x135:396x125)/arc-anglerfish-arc2-prod-advancelocal.s3.amazonaws.com/public/5KNL2T3HZZE4TKRYTKFYMMBPSI.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:48:00Z\",\n" +
                "            \"content\": \"A snowy Saturday awaits for the northern half of New Jersey with up to four inches of snow expected from late morning through the afternoon before a change to sleet and rain in the evening, forecasters say.\\r\\nThe National Weather Service has issued a winter we… [+2285 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"cnn\",\n" +
                "                \"name\": \"CNN\"\n" +
                "            },\n" +
                "            \"author\": \"Rob Picheta and Jack Guy, CNN\",\n" +
                "            \"title\": \"Pregnant woman and six children tortured and killed by a religious cult in Panama, authorities say - CNN\",\n" +
                "            \"description\": \"A pregnant woman and six children -- including a 1-year-old baby and a 3-year-old -- were tortured, slaughtered and buried in a mass grave in Panama as part of a bizarre, ritualistic killing by a religious cult, authorities have said.\",\n" +
                "            \"url\": \"https://www.cnn.com/2020/01/17/americas/panama-religious-sect-killings-scli-intl/index.html\",\n" +
                "            \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/200117041356-panama-cult-arrest-super-tease.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:46:00Z\",\n" +
                "            \"content\": \"(CNN)A pregnant woman and six children -- including a 1-year-old baby and a 3-year-old -- were tortured, slaughtered and buried in a mass grave in Panama as part of a bizarre, ritualistic killing by a religious cult, authorities have said.\\r\\nNine indigenous pe… [+1579 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Youtube.com\"\n" +
                "            },\n" +
                "            \"author\": null,\n" +
                "            \"title\": \"So Blyeth Is Coming To Smash & Three Houses Is Getting A Fourth House! - Nintendo Life\",\n" +
                "            \"description\": \"Byleth in Super Smash Bros Ultimate and a brand new house has been revealed for Fire Emblem Three Houses? It was a big day for Fire Emblem Fans! Byleth Super...\",\n" +
                "            \"url\": \"https://www.youtube.com/watch?v=hwjO0bPxKco\",\n" +
                "            \"urlToImage\": \"https://i.ytimg.com/vi/hwjO0bPxKco/maxresdefault.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:38:54Z\",\n" +
                "            \"content\": \"Byleth in Super Smash Bros Ultimate and a brand new house has been revealed for Fire Emblem Three Houses? It was a big day for Fire Emblem Fans!\\r\\nByleth Super Smash Bros Ultimate Character Details: https://www.nintendolife.com/news/202...\\r\\nFire Emblem Three H… [+294 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"usa-today\",\n" +
                "                \"name\": \"USA Today\"\n" +
                "            },\n" +
                "            \"author\": \"Kim Hjelmgaard\",\n" +
                "            \"title\": \"Iran Supreme Leader Ayatollah Ali Khamenei calls Trump a 'clown,' defends Iran's military - USA TODAY\",\n" +
                "            \"description\": \"Iran's Supreme Leader Ayatollah Ali Khamenei called President Donald Trump a \\\"clown\\\" as he led Friday prayers in Tehran for the first time since 2012.\",\n" +
                "            \"url\": \"https://www.usatoday.com/story/news/world/2020/01/17/irans-supreme-leader-ayatollah-ali-khamanei-donald-trump-clown-middle-east-tensions/4487053002/?utm_source=google&utm_medium=amp&utm_campaign=speakable\",\n" +
                "            \"urlToImage\": \"https://www.gannett-cdn.com/presto/2020/01/17/USAT/69120388-a60d-4fa9-854a-fc9c66aeeb53-AFP_1NU0C4.JPG?crop=2221,1249,x1,y6&width=1600&height=800&fit=bounds\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:29:11Z\",\n" +
                "            \"content\": \"Supreme Leader Ayatollah Ali Khamenei called President Donald Trump a \\\"clown\\\" as he defended Iran's military after it mistakenly shot down a Ukrainian passenger plane, in a relatively rare public address that came as he led Friday prayers in Tehran.\\r\\nThe last… [+3784 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"reuters\",\n" +
                "                \"name\": \"Reuters\"\n" +
                "            },\n" +
                "            \"author\": \"Reuters Editorial\",\n" +
                "            \"title\": \"U.S. to review petition seeking formal defect probe into 500,000 Tesla vehicles - Reuters\",\n" +
                "            \"description\": \"The National Highway Traffic Safety Administration (NHTSA) said Friday it will review a petition asking the agency to formally investigate 500,000 Tesla Inc models over sudden unintended acceleration reports.\",\n" +
                "            \"url\": \"https://www.reuters.com/article/us-tesla-probe-idUSKBN1ZG1IL\",\n" +
                "            \"urlToImage\": \"https://s4.reutersmedia.net/resources/r/?m=02&d=20200117&t=2&i=1477711523&w=1200&r=LYNXMPEG0G118\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:14:00Z\",\n" +
                "            \"content\": \"WASHINGTON (Reuters) - The National Highway Traffic Safety Administration (NHTSA) said Friday it will review a petition asking the agency to formally investigate 500,000 Tesla Inc models over sudden unintended acceleration reports. \\r\\nThe petition covers 2012 … [+386 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"cnn\",\n" +
                "                \"name\": \"CNN\"\n" +
                "            },\n" +
                "            \"author\": \"Jackie Wattles, CNN Business\",\n" +
                "            \"title\": \"Commercial spaceflight is no longer a pipe dream. Here's what's next - CNN\",\n" +
                "            \"description\": \"The last decade gave rise to more than 500 startups in the commercial spaceflight sector, prompting analysts to dub it one of the most exciting new markets to watch. And this year could mark a major turning point — as young companies continue to evolve from w…\",\n" +
                "            \"url\": \"https://www.cnn.com/2020/01/17/tech/spaceflight-mergers-acquisitions-ipos/index.html\",\n" +
                "            \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/181111161738-rocket-lab-launch-1111-super-tease.jpeg\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:03:00Z\",\n" +
                "            \"content\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"engadget\",\n" +
                "                \"name\": \"Engadget\"\n" +
                "            },\n" +
                "            \"author\": \"Richard Lawler\",\n" +
                "            \"title\": \"The Morning After: Comcast and NBC explain their Peacock streaming service - Engadget\",\n" +
                "            \"description\": \"This morning's roundup includes news of a delay for 'Cyberpunk 2077' and all the details about NBC's Peacock streaming service.\",\n" +
                "            \"url\": \"https://www.engadget.com/2020/01/17/peacock-cyberpunk-2077/\",\n" +
                "            \"urlToImage\": \"https://o.aolcdn.com/images/dims?thumbnail=1200%2C630&quality=80&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fresize%3D2000%252C2000%252Cshrink%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-uploaded-images%252F2020-01%252F5e24d3f0-3920-11ea-a379-508ce4c3fabc%26client%3Da1acac3e1b3290917d92%26signature%3Dabf56a860fa01b5c5be6fdd9414e7c46e957236c&client=amp-blogside-v2&signature=61d2f3a430c97a1576028c2f31590a12e909779b\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:00:24Z\",\n" +
                "            \"content\": \"Ready for another trip?Engadget Podcast: Super Nintendo World, here we go!\\r\\nDevindra, Cherlynn and Senior Editor Nick Summers take a relaxing break from the madness of CES by diving into some of this week's news, like the trailer for Japan's Super Nintendo Wo… [+3713 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Youtube.com\"\n" +
                "            },\n" +
                "            \"author\": null,\n" +
                "            \"title\": \"Why Australia's fires are linked to floods in Africa - Vox\",\n" +
                "            \"description\": \"Fires are normal in Australia. This year was off the charts. Australia’s recent fire season has been hellish with no end in sight. At least 17.9 million acre...\",\n" +
                "            \"url\": \"https://www.youtube.com/watch?v=RYX9ahqceAI\",\n" +
                "            \"urlToImage\": \"https://i.ytimg.com/vi/RYX9ahqceAI/maxresdefault.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T13:00:06Z\",\n" +
                "            \"content\": \"Fires are normal in Australia. This year was off the charts.\\r\\nAustralias recent fire season has been hellish with no end in sight. At least 17.9 million acres have burned, 28 people have died, and an estimated 1 billion animals have been lost. \\r\\nBut while Aus… [+1302 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"cbs-news\",\n" +
                "                \"name\": \"CBS News\"\n" +
                "            },\n" +
                "            \"author\": \"CBS News\",\n" +
                "            \"title\": \"Deb Dugan: New Grammys head put on leave just 10 days before this year's broadcast - CBS News\",\n" +
                "            \"description\": \"The Recording Academy says the move against Deborah Dugan follows a formal misconduct allegation by a senior academy team member.\",\n" +
                "            \"url\": \"https://www.cbsnews.com/news/deb-dugan-new-grammys-head-deboarah-dugan-put-on-leave-just-10-days-before-this-years-broadcast/\",\n" +
                "            \"urlToImage\": \"https://cbsnews3.cbsistatic.com/hub/i/r/2020/01/17/8f3840b3-af31-4a3f-8835-2afb4388a2a4/thumbnail/1200x630/bddba15fa413869a67d95c618d29b512/gettyimages-1188919681.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T12:58:00Z\",\n" +
                "            \"content\": \"The Recording Academy has placed Deborah Dugan, its president and CEO of just six months, on administrative leave following an allegation of misconduct by a senior leader at the organization. The move announced late Thursday comes 10 days before the 2020 Gram… [+2652 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Npr.org\"\n" +
                "            },\n" +
                "            \"author\": \"Scott Neuman\",\n" +
                "            \"title\": \"In China, Birth Rate Falls To Lowest Level In 70 Years - NPR\",\n" +
                "            \"description\": \"Last year, there were 10.48 births per 1,000 people — the lowest since the People's Republic of China was founded. Beijing also said its economy cooled to the slowest pace in nearly three decades.\",\n" +
                "            \"url\": \"https://www.npr.org/2020/01/17/797230518/in-china-gdp-growth-falls-to-lowest-level-in-nearly-30-years\",\n" +
                "            \"urlToImage\": \"https://media.npr.org/assets/img/2020/01/17/gettyimages-1190106458_wide-c1cca554370a58db987371412dae569a17d91f30.jpg?s=1400\",\n" +
                "            \"publishedAt\": \"2020-01-17T12:17:00Z\",\n" +
                "            \"content\": \"A woman carries a baby born on China's National Day on Oct. 1, 2019, at a hospital in Chengdu, Sichuan Province of China.\\r\\nVisual China Group via Getty Ima\\r\\nUpdated at 9 a.m. ET\\r\\nNew birth-rate figures show that China has so far failed to reverse the effects … [+3544 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Gizmodo.com\"\n" +
                "            },\n" +
                "            \"author\": \"Matt Novak\",\n" +
                "            \"title\": \"Deadly Mystery Virus Spreads Outside China to New Countries - Gizmodo\",\n" +
                "            \"description\": \"Health officials in Thailand and Japan have announced that a strange new virus, which has killed two people and sickened dozens of others in China, has appeared inside their borders this week. The virus, known as 2019-nCoV, was first identified in Wuhan, Chin…\",\n" +
                "            \"url\": \"https://gizmodo.com/mystery-virus-spreads-to-new-countries-outside-china-1841057194\",\n" +
                "            \"urlToImage\": \"https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/d9mr8ypwedqb6rvtk6yp.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T12:15:00Z\",\n" +
                "            \"content\": \"Health officials in Thailand and Japan have announced that a strange new virus, which has killed two people and sickened dozens of others in China, has appeared inside their borders this week. The virus, known as 2019-nCoV, was first identified in Wuhan, Chin… [+4032 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Livescience.com\"\n" +
                "            },\n" +
                "            \"author\": \"Rachael Rettner\",\n" +
                "            \"title\": \"The Surprising Condition That Causes 1 in 5 Deaths - Livescience.com\",\n" +
                "            \"description\": \"More people die from sepsis than cancer.\",\n" +
                "            \"url\": \"https://www.livescience.com/sepsis-deaths-worldwide.html\",\n" +
                "            \"urlToImage\": \"https://cdn.mos.cms.futurecdn.net/7fMCvEEWTFAaXP5rX4ByJa-1200-80.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T12:00:00Z\",\n" +
                "            \"content\": \"The number of deaths from sepsis\\r\\n worldwide is much higher than previously thought, with an estimated 20% of people dying from the life-threatening condition, according to a new study.\\r\\nThe study, published today (Jan. 16) in the journal The Lancet\\r\\n, estima… [+2604 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Nbcsports.com\"\n" +
                "            },\n" +
                "            \"author\": \"Josh Alper\",\n" +
                "            \"title\": \"Davante Adams: Pressure’s really on 49ers - NBCSports.com\",\n" +
                "            \"description\": \"The Packers won 13 games in the regular season and they’re taking a six-game winning streak with them into Sunday’s game, but they aren’t favored to beat the 49ers. Green Bay is a 7.5-point underdog ahead of their trip to Santa Clara to play for the NFC title…\",\n" +
                "            \"url\": \"https://profootballtalk.nbcsports.com/2020/01/17/davante-adams-pressures-really-on-49ers/\",\n" +
                "            \"urlToImage\": \"https://nbcprofootballtalk.files.wordpress.com/2020/01/gettyimages-1199274676-e1579262203135.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T11:57:00Z\",\n" +
                "            \"content\": \"The Packers won 13 games in the regular season and they’re taking a six-game winning streak with them into Sunday’s game, but they aren’t favored to beat the 49ers.\\r\\nGreen Bay is a 7.5-point underdog ahead of their trip to Santa Clara to play for the NFC titl… [+1166 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"cnbc\",\n" +
                "                \"name\": \"CNBC\"\n" +
                "            },\n" +
                "            \"author\": \"Silvia Amaro\",\n" +
                "            \"title\": \"Apple may be forced to ditch its Lightning charge cable due to new EU rules - CNBC\",\n" +
                "            \"description\": \"The EU is revamping plans that could force smartphone makers, such as Apple, to share the same charging method.\",\n" +
                "            \"url\": \"https://www.cnbc.com/2020/01/17/apple-may-be-forced-to-ditch-lightning-charge-cable-amid-new-eu-rules.html\",\n" +
                "            \"urlToImage\": \"https://image.cnbcfm.com/api/v1/image/106341912-1579259610427gettyimages-599191090.jpeg?v=1579259659\",\n" +
                "            \"publishedAt\": \"2020-01-17T11:15:00Z\",\n" +
                "            \"content\": \"The European Union (EU) is revamping plans that could force smartphone makers, such as Apple, to share the same charging method.\\r\\nEuropean policymakers want to make life easier for consumers as well as to reduce electronic waste across the 28-country region. … [+2659 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"reuters\",\n" +
                "                \"name\": \"Reuters\"\n" +
                "            },\n" +
                "            \"author\": \"Simon Lewis\",\n" +
                "            \"title\": \"Flap with Warren knocks Sanders' strategy off course - Reuters\",\n" +
                "            \"description\": \"The best-laid plans of Democratic presidential contender Bernie Sanders were upended this week – and his campaign is struggling to get back on track.\",\n" +
                "            \"url\": \"https://www.reuters.com/article/us-usa-election-sanders-warren-idUSKBN1ZG17G\",\n" +
                "            \"urlToImage\": \"https://s2.reutersmedia.net/resources/r/?m=02&d=20200117&t=2&i=1477683949&w=1200&r=LYNXMPEG0G0RD\",\n" +
                "            \"publishedAt\": \"2020-01-17T11:13:00Z\",\n" +
                "            \"content\": \"WASHINGTON (Reuters) - The best-laid plans of Democratic presidential contender Bernie Sanders were upended this week and his campaign is struggling to get back on track. \\r\\nSanders went into the week looking to draw a sharper contrast between his progressive … [+5179 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"usa-today\",\n" +
                "                \"name\": \"USA Today\"\n" +
                "            },\n" +
                "            \"author\": \"Robert Powell\",\n" +
                "            \"title\": \"4 changes coming to Social Security in 2020 - USA TODAY\",\n" +
                "            \"description\": \"If you’re one of some 69 million Americans who receive Social Security or SSI benefits, you’ll notice some changes in 2020. Here are four.\",\n" +
                "            \"url\": \"https://www.usatoday.com/story/money/2020/01/17/social-security-2020-6-changes-you-should-expect-year/2827098001/\",\n" +
                "            \"urlToImage\": \"https://www.gannett-cdn.com/-mm-/7b8d685236991fea6889d164f95997b3c1c36417/c=0-375-7200-4425/local/-/media/2020/01/03/USATODAY/usatsports/social-security-benefit-application-getty.jpg?width=3200&height=1800&fit=crop&format=pjpg&auto=webp\",\n" +
                "            \"publishedAt\": \"2020-01-17T11:09:13Z\",\n" +
                "            \"content\": \"If youre one of almost 69 million Americans who receive Social Security or Supplemental Security Income (SSI) benefits, youll notice a small change in your monthly check this year.\\r\\nMore than 63 million beneficiaries will receive a 1.6% cost-of-living adjustm… [+5140 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"the-washington-post\",\n" +
                "                \"name\": \"The Washington Post\"\n" +
                "            },\n" +
                "            \"author\": \"Teo Armus\",\n" +
                "            \"title\": \"Norovirus outbreak hits Yosemite Valley Park, with 170 suffering symptoms - Washington Post\",\n" +
                "            \"description\": \"Two cases of the highly contagious gastrointestinal illness have been confirmed, park officials said.\",\n" +
                "            \"url\": \"https://www.washingtonpost.com/nation/2020/01/17/yosemite-norovirus-outbreak/\",\n" +
                "            \"urlToImage\": \"https://www.washingtonpost.com/resizer/fQISe7-9h4IsbUPfOsW2LinVlJE=/1440x0/smart/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/P36AODDGXQI6RAOKXMKFSOWKUY.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T10:41:00Z\",\n" +
                "            \"content\": \"It seems their Yosemite getaway is to blame.\\r\\nPark officials said on Thursday that the California destination, best known for its giant sequoia trees and sweeping views of the Sierra Nevada range, is now host to something far less picturesque: a highly contag… [+3286 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Androidauthority.com\"\n" +
                "            },\n" +
                "            \"author\": null,\n" +
                "            \"title\": \"Samsung Galaxy S20 optical zoom could be capped at 5x instead on 10x - Android Authority\",\n" +
                "            \"description\": \"Could Samsung cap optical zoom to 5x instead on 10x?\",\n" +
                "            \"url\": \"https://www.androidauthority.com/galaxy-s20-zoom-camera-1075563/\",\n" +
                "            \"urlToImage\": \"https://cdn57.androidauthority.net/wp-content/uploads/2019/11/Samsung-Galaxy-S11-Plus-Renders-OnLeaks-3-920x470.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T10:40:56Z\",\n" +
                "            \"content\": \"Cash KaroJust a couple of days ago, we got wind of the Samsung Galaxy S20 Ultra with its mad zoom capabilities. It was rumored that the phone will feature 10x optical zoom. However, a new report now has us second guessing the previous leak.\\r\\nAccording to The … [+1435 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": \"cnn\",\n" +
                "                \"name\": \"CNN\"\n" +
                "            },\n" +
                "            \"author\": \"Jake Tapper, Ryan Browne and Barbara Starr, CNN\",\n" +
                "            \"title\": \"US troops were injured in Iran missile attack despite Pentagon initially saying there were no casualties - CNN\",\n" +
                "            \"description\": \"Several US service members were injured during last week's Iranian missile attack on Al-Asad airbase in Iraq despite the Pentagon initially saying that no casualties had taken place.\",\n" +
                "            \"url\": \"https://www.cnn.com/2020/01/16/politics/service-members-injured-iran-strike/index.html\",\n" +
                "            \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/200113093539-iraq-al-asad-base-rocket-1-super-tease.jpg\",\n" +
                "            \"publishedAt\": \"2020-01-17T10:21:00Z\",\n" +
                "            \"content\": \"(CNN)Several US service members were injured during last week's Iranian missile attack on Al-Asad airbase in Iraq despite the Pentagon initially saying that no casualties had taken place.\\r\\n\\\"While no U.S. service members were killed in the Jan. 8 Iranian attac… [+5211 chars]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"source\": {\n" +
                "                \"id\": null,\n" +
                "                \"name\": \"Npr.org\"\n" +
                "            },\n" +
                "            \"author\": null,\n" +
                "            \"title\": \"Reporters Battle New Restrictions In Trying To Cover Senate Impeachment Trial - NPR\",\n" +
                "            \"description\": \"Authorities are cracking down on the places correspondents may go, with whom they may talk and for how long. News outlets don't want to go along.\",\n" +
                "            \"url\": \"https://www.npr.org/2020/01/17/797126423/reporters-battle-new-restrictions-in-trying-to-cover-senate-impeachment-trial\",\n" +
                "            \"urlToImage\": \"https://media.npr.org/assets/img/2020/01/16/ap_18025740725340_wide-6d0a07e6e4268feac4cbcda242d57feff07f2dfd.jpg?s=1400\",\n" +
                "            \"publishedAt\": \"2020-01-17T10:00:00Z\",\n" +
                "            \"content\": \"Senate Judiciary Committee Chairman Chuck Grassley, R-Iowa, speaks with reporters after a vote. Journalists' normal access is being constrained for the impeachment trial.\\r\\nJ. Scott Applewhite/AP\\r\\nNews organizations and journalists' advocates are battling rest… [+4010 chars]\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
