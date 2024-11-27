package com.example.firstapplicationchiara

import TmdbResult2
import TmdbResult3
import TmdbResult4
import TmdbResult5
import TmdbResults
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.http.Query

class FakeTmdbApi : TmbdAPI{

    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<TmdbResults> = moshi.adapter(TmdbResults::class.java)

    // Faux Json
    val jsonresult = "{\n" +
            "    \"page\": 1,\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/w22GVYotTIVC1dUd58mRhwPqiS.jpg\",\n" +
            "            \"id\": 402431,\n" +
            "            \"title\": \"Wicked\",\n" +
            "            \"original_title\": \"Wicked\",\n" +
            "            \"overview\": \"Elphaba, a young woman misunderstood because of her green skin, and Glinda, a popular aristocrat gilded by privilege, become unlikely friends in the fantastical Land of Oz. As the two women struggle with their opposing personalities, their friendship is tested as both begin to fulfill their destinies as Glinda the Good and the Wicked Witch of the West.\",\n" +
            "            \"poster_path\": \"/c5Tqxeo1UpBvnAc3csUm7j3hlQl.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                14,\n" +
            "                10749\n" +
            "            ],\n" +
            "            \"popularity\": 1477.864,\n" +
            "            \"release_date\": \"2024-11-20\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.8,\n" +
            "            \"vote_count\": 188\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/iR79ciqhtaZ9BE7YFA1HpCHQgX4.jpg\",\n" +
            "            \"id\": 1100782,\n" +
            "            \"title\": \"Smile 2\",\n" +
            "            \"original_title\": \"Smile 2\",\n" +
            "            \"overview\": \"About to embark on a new world tour, global pop sensation Skye Riley begins experiencing increasingly terrifying and inexplicable events. Overwhelmed by the escalating horrors and the pressures of fame, Skye is forced to face her dark past to regain control of her life before it spirals out of control.\",\n" +
            "            \"poster_path\": \"/ht8Uv9QPv9y7K0RvUyJIaXOZTfd.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                27,\n" +
            "                9648\n" +
            "            ],\n" +
            "            \"popularity\": 2261.273,\n" +
            "            \"release_date\": \"2024-10-16\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.836,\n" +
            "            \"vote_count\": 648\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/tkRDTu9hyWgaBSSzfkYDCZYd1kV.jpg\",\n" +
            "            \"id\": 974576,\n" +
            "            \"title\": \"Conclave\",\n" +
            "            \"original_title\": \"Conclave\",\n" +
            "            \"overview\": \"After the unexpected death of the Pope, Cardinal Lawrence is tasked with managing the covert and ancient ritual of electing a new one. Sequestered in the Vatican with the Catholic Church’s most powerful leaders until the process is complete, Lawrence finds himself at the center of a conspiracy that could lead to its downfall.\",\n" +
            "            \"poster_path\": \"/1j9r59YQ0a7kM9AKX9MCvf90QNS.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                9648,\n" +
            "                53,\n" +
            "                18\n" +
            "            ],\n" +
            "            \"popularity\": 73.693,\n" +
            "            \"release_date\": \"2024-10-25\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.4,\n" +
            "            \"vote_count\": 38\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/tElnmtQ6yz1PjN1kePNl8yMSb59.jpg\",\n" +
            "            \"id\": 1241982,\n" +
            "            \"title\": \"Moana 2\",\n" +
            "            \"original_title\": \"Moana 2\",\n" +
            "            \"overview\": \"After receiving an unexpected call from her wayfinding ancestors, Moana journeys alongside Maui and a new crew to the far seas of Oceania and into dangerous, long-lost waters for an adventure unlike anything she's ever faced.\",\n" +
            "            \"poster_path\": \"/m0SbwFNCa9epW1X60deLqTHiP7x.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                12,\n" +
            "                10751,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"popularity\": 1324.077,\n" +
            "            \"release_date\": \"2024-11-27\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.8,\n" +
            "            \"vote_count\": 19\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/n4ycOGj2tRLfINTJQ3wl0vNYqpR.jpg\",\n" +
            "            \"id\": 592983,\n" +
            "            \"title\": \"Spellbound\",\n" +
            "            \"original_title\": \"Spellbound\",\n" +
            "            \"overview\": \"When a powerful spell turns her parents into giant monsters, a teenage princess must journey into the wild to reverse the curse before it's too late.\",\n" +
            "            \"poster_path\": \"/xFSIygDiX70Esp9dheCgGX0Nj77.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                14,\n" +
            "                10751,\n" +
            "                12,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"popularity\": 464.558,\n" +
            "            \"release_date\": \"2024-11-22\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.8,\n" +
            "            \"vote_count\": 61\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/euYIwmwkmz95mnXvufEmbL6ovhZ.jpg\",\n" +
            "            \"id\": 558449,\n" +
            "            \"title\": \"Gladiator II\",\n" +
            "            \"original_title\": \"Gladiator II\",\n" +
            "            \"overview\": \"Years after witnessing the death of the revered hero Maximus at the hands of his uncle, Lucius is forced to enter the Colosseum after his home is conquered by the tyrannical Emperors who now lead Rome with an iron fist. With rage in his heart and the future of the Empire at stake, Lucius must look to his past to find strength and honor to return the glory of Rome to its people.\",\n" +
            "            \"poster_path\": \"/2cxhvwyEwRlysAmRH4iodkvo0z5.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12\n" +
            "            ],\n" +
            "            \"popularity\": 1755.715,\n" +
            "            \"release_date\": \"2024-11-13\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.8,\n" +
            "            \"vote_count\": 703\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/rXYejcyn762o3cjp9OYfyVR3QpY.jpg\",\n" +
            "            \"id\": 940139,\n" +
            "            \"title\": \"Here\",\n" +
            "            \"original_title\": \"Here\",\n" +
            "            \"overview\": \"An odyssey through time and memory, centered around a place in New England where—from wilderness, and then, later, from a home—love, loss, struggle, hope and legacy play out between couples and families over generations.\",\n" +
            "            \"poster_path\": \"/79euHUJJtfgeGU63ef38KtNjXEn.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                18\n" +
            "            ],\n" +
            "            \"popularity\": 32.715,\n" +
            "            \"release_date\": \"2024-10-30\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.7,\n" +
            "            \"vote_count\": 40\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/au3o84ub27qTZiMiEc9UYzN74V3.jpg\",\n" +
            "            \"id\": 1035048,\n" +
            "            \"title\": \"Elevation\",\n" +
            "            \"original_title\": \"Elevation\",\n" +
            "            \"overview\": \"A single father and two women venture from the safety of their homes to face monstrous creatures to save the life of a young boy.\",\n" +
            "            \"poster_path\": \"/uQhYBxOVFU6s9agD49FnGHwJqG5.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                878,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"popularity\": 106.71,\n" +
            "            \"release_date\": \"2024-11-07\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.4,\n" +
            "            \"vote_count\": 17\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/4eMqcuVITc6iY25rRApqRFGr5VP.jpg\",\n" +
            "            \"id\": 896151,\n" +
            "            \"title\": \"Blitz\",\n" +
            "            \"original_title\": \"Blitz\",\n" +
            "            \"overview\": \"In World War II London, nine-year-old George is evacuated to the countryside by his mother, Rita, to escape the bombings. Defiant and determined to return to his family, George embarks on an epic, perilous journey back home as Rita searches for him.\",\n" +
            "            \"poster_path\": \"/e9tyjbF2rugENtBolTtEhHOXgzD.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                10752,\n" +
            "                18,\n" +
            "                36\n" +
            "            ],\n" +
            "            \"popularity\": 175.608,\n" +
            "            \"release_date\": \"2024-11-01\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.223,\n" +
            "            \"vote_count\": 56\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/zpaodBqO2lcwJh2SQrFFf1Rn8Jy.jpg\",\n" +
            "            \"id\": 1100099,\n" +
            "            \"title\": \"We Live in Time\",\n" +
            "            \"original_title\": \"We Live in Time\",\n" +
            "            \"overview\": \"An up-and-coming chef and a recent divorcée find their lives forever changed when a chance encounter brings them together, in a decade-spanning, deeply moving romance.\",\n" +
            "            \"poster_path\": \"/oeDNBgnlGF6rnyX1P1K8Vl2f3lW.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                10749,\n" +
            "                18,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"popularity\": 614.524,\n" +
            "            \"release_date\": \"2024-10-10\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.6,\n" +
            "            \"vote_count\": 84\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/v9acaWVVFdZT5yAU7J2QjwfhXyD.jpg\",\n" +
            "            \"id\": 1184918,\n" +
            "            \"title\": \"The Wild Robot\",\n" +
            "            \"original_title\": \"The Wild Robot\",\n" +
            "            \"overview\": \"After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island's animals and cares for an orphaned baby goose.\",\n" +
            "            \"poster_path\": \"/wTnV3PCVW5O92JMrFvvrRcV39RU.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                878,\n" +
            "                10751\n" +
            "            ],\n" +
            "            \"popularity\": 2014.165,\n" +
            "            \"release_date\": \"2024-09-12\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 8.445,\n" +
            "            \"vote_count\": 3114\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/9SSEUrSqhljBMzRe4aBTh17rUaC.jpg\",\n" +
            "            \"id\": 945961,\n" +
            "            \"title\": \"Alien: Romulus\",\n" +
            "            \"original_title\": \"Alien: Romulus\",\n" +
            "            \"overview\": \"While scavenging the deep ends of a derelict space station, a group of young space colonizers come face to face with the most terrifying life form in the universe.\",\n" +
            "            \"poster_path\": \"/b33nnKl1GSFbao4l3fZDDqsMx0F.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                27,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"popularity\": 977.487,\n" +
            "            \"release_date\": \"2024-08-13\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.258,\n" +
            "            \"vote_count\": 2420\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/dvBCdCohwWbsP5qAaglOXagDMtk.jpg\",\n" +
            "            \"id\": 533535,\n" +
            "            \"title\": \"Deadpool & Wolverine\",\n" +
            "            \"original_title\": \"Deadpool & Wolverine\",\n" +
            "            \"overview\": \"A listless Wade Wilson toils away in civilian life with his days as the morally flexible mercenary, Deadpool, behind him. But when his homeworld faces an existential threat, Wade must reluctantly suit-up again with an even more reluctant Wolverine.\",\n" +
            "            \"poster_path\": \"/8cdWjvZQUExUUTzyp4t6EDMubfO.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                35,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"popularity\": 1197.687,\n" +
            "            \"release_date\": \"2024-07-24\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.688,\n" +
            "            \"vote_count\": 5606\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/ytorq8y3v9g1P4sXDFv2tbNg7Ms.jpg\",\n" +
            "            \"id\": 804406,\n" +
            "            \"title\": \"The Piano Lesson\",\n" +
            "            \"original_title\": \"The Piano Lesson\",\n" +
            "            \"overview\": \"A brother and sister's battle over a prized heirloom piano unleashes haunting truths about how the past is perceived — and who defines a family legacy.\",\n" +
            "            \"poster_path\": \"/cgampq63AqCrza6bnvmWqCcvCzY.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                18\n" +
            "            ],\n" +
            "            \"popularity\": 72.03,\n" +
            "            \"release_date\": \"2024-11-07\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.8,\n" +
            "            \"vote_count\": 20\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/7h6TqPB3ESmjuVbxCxAeB1c9OB1.jpg\",\n" +
            "            \"id\": 933260,\n" +
            "            \"title\": \"The Substance\",\n" +
            "            \"original_title\": \"The Substance\",\n" +
            "            \"overview\": \"A fading celebrity decides to use a black market drug, a cell-replicating substance that temporarily creates a younger, better version of herself.\",\n" +
            "            \"poster_path\": \"/lqoMzCcZYEFK729d6qzt349fB4o.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                27,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"popularity\": 1102.71,\n" +
            "            \"release_date\": \"2024-09-07\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.3,\n" +
            "            \"vote_count\": 2211\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/thDLoKyWdgK6EWXwGsjYqAFenuN.jpg\",\n" +
            "            \"id\": 1182387,\n" +
            "            \"title\": \"Armor\",\n" +
            "            \"original_title\": \"Armor\",\n" +
            "            \"overview\": \"Armored truck security guard James Brody is working with his son Casey transporting millions of dollars between banks when a team of thieves led by Rook orchestrate a takeover of their truck to seize the riches. Following a violent car chase, Rook soon has the armored truck surrounded and James and Casey find themselves cornered onto a decrepit bridge.\",\n" +
            "            \"poster_path\": \"/pnXLFioDeftqjlCVlRmXvIdMsdP.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                80,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"popularity\": 135.589,\n" +
            "            \"release_date\": \"2024-10-30\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.313,\n" +
            "            \"vote_count\": 16\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/6lE2e6j8qbtQR8aHxQNJlwxdmKV.jpg\",\n" +
            "            \"id\": 974453,\n" +
            "            \"title\": \"Absolution\",\n" +
            "            \"original_title\": \"Absolution\",\n" +
            "            \"overview\": \"An aging ex-boxer gangster working as muscle for a Boston crime boss receives an upsetting diagnosis.  Despite a faltering memory, he attempts to rectify the sins of his past and reconnect with his estranged children. He is determined to leave a positive legacy for his grandson, but the criminal underworld isn’t done with him and won’t loosen their grip willingly.\",\n" +
            "            \"poster_path\": \"/cNtAslrDhk1i3IOZ16vF7df6lMy.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                18,\n" +
            "                80,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"popularity\": 266.319,\n" +
            "            \"release_date\": \"2024-10-31\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.1,\n" +
            "            \"vote_count\": 56\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/jhk6D8pim3yaByu1801kMoxXFaX.jpg\",\n" +
            "            \"id\": 98,\n" +
            "            \"title\": \"Gladiator\",\n" +
            "            \"original_title\": \"Gladiator\",\n" +
            "            \"overview\": \"After the death of Emperor Marcus Aurelius, his devious son takes power and demotes Maximus, one of Rome's most capable generals who Marcus preferred. Eventually, Maximus is forced to become a gladiator and battle to the death against other men for the amusement of paying audiences.\",\n" +
            "            \"poster_path\": \"/ty8TGRuvJLPUmAR1H1nRIsgwvim.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                18,\n" +
            "                12\n" +
            "            ],\n" +
            "            \"popularity\": 504.129,\n" +
            "            \"release_date\": \"2000-05-04\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 8.217,\n" +
            "            \"vote_count\": 18703\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/m2teNSCH7sxkuXHossRJXhxPKeT.jpg\",\n" +
            "            \"id\": 939243,\n" +
            "            \"title\": \"Sonic the Hedgehog 3\",\n" +
            "            \"original_title\": \"Sonic the Hedgehog 3\",\n" +
            "            \"overview\": \"Sonic, Knuckles, and Tails reunite against a powerful new adversary, Shadow, a mysterious villain with powers unlike anything they have faced before. With their abilities outmatched in every way, Team Sonic must seek out an unlikely alliance in hopes of stopping Shadow and protecting the planet.\",\n" +
            "            \"poster_path\": \"/psBkoP6zqEZhsDXfP387n3zmZVx.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                35,\n" +
            "                10751,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"popularity\": 310.743,\n" +
            "            \"release_date\": \"2024-12-19\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 0,\n" +
            "            \"vote_count\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"backdrop_path\": \"/rOmUuQEZfPXglwFs5ELLLUDKodL.jpg\",\n" +
            "            \"id\": 845781,\n" +
            "            \"title\": \"Red One\",\n" +
            "            \"original_title\": \"Red One\",\n" +
            "            \"overview\": \"After Santa Claus (codename: Red One) is kidnapped, the North Pole's Head of Security must team up with the world's most infamous bounty hunter in a globe-trotting, action-packed mission to save Christmas.\",\n" +
            "            \"poster_path\": \"/cdqLnri3NEGcmfnqwk2TSIYtddg.jpg\",\n" +
            "            \"media_type\": \"movie\",\n" +
            "            \"adult\": false,\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                35,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"popularity\": 844.503,\n" +
            "            \"release_date\": \"2024-10-31\",\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.645,\n" +
            "            \"vote_count\": 169\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total_pages\": 500,\n" +
            "    \"total_results\": 10000\n" +
            "}"



    override suspend fun movieList(apikey: String): TmdbResults {
        val res = jsonAdapter.fromJson(jsonresult)
        if (res != null) return res
        else return TmdbResults(1,emptyList(),1,1)
    }

    override suspend fun getFilmsByKeyWord(apiKey: String, keyWord: String): TmdbResults {
        TODO("Not yet implemented")
    }

    override suspend fun serieList(apikey: String): TmdbResult2 {
        TODO("Not yet implemented")
    }

    override suspend fun getSeriesByKeyWord(apiKey: String, keyWord: String): TmdbResult2 {
        TODO("Not yet implemented")
    }

    override suspend fun actorsList(apikey: String): TmdbResult3 {
        TODO("Not yet implemented")
    }

    override suspend fun getPersonByKeyWord(apiKey: String, keyWord: String): TmdbResult3 {
        TODO("Not yet implemented")
    }

    override suspend fun getFilmDetail(movieId: String, apikey: String): TmdbResult4 {
        TODO("Not yet implemented")
    }

    override suspend fun getSerieDetail(tvId: String, apikey: String): TmdbResult5 {
        TODO("Not yet implemented")
    }
}