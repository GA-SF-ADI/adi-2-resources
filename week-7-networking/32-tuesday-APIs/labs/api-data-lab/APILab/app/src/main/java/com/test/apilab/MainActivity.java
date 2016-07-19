package com.test.apilab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Gson gson;

    public static final String CURRENTLOCATION_JSON = "{ \"photos\": { \"page\": 1, \"pages\": \"2436\", \"perpage\": 100, \"total\": \"243558\", \n" +
            "    \"photo\": [\n" +
            "      { \"id\": \"27803682673\", \"owner\": \"77176477@N00\", \"secret\": \"3c50a3ee22\", \"server\": \"8867\", \"farm\": 9, \"title\": \"Hot out of the kiln, Oil Cans, black stoneware with underglaze  @SMAartGallery @smaartworks #blackstoneware #smaart #rustbelt #art #pottery #clay #ceramics #oilcans\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28386689706\", \"owner\": \"49502995517@N01\", \"secret\": \"3611e1a0bc\", \"server\": \"8782\", \"farm\": 9, \"title\": \"Lost on Lundys\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28419581385\", \"owner\": \"64214472@N04\", \"secret\": \"a1e02041d7\", \"server\": \"7663\", \"farm\": 8, \"title\": \"#Repost @wildbayarea with @repostapp ・・・ ✦ ✨\uD83D\uDC49Photo by: @andreweggers\uD83D\uDC48✨ Selected by: @kurtzmanos ✦ We are excited to present one of today's Featured Photos of the Day. ✦ Congratulations! \uD83C\uDFC6 Please have a look\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28386469776\", \"owner\": \"70238393@N00\", \"secret\": \"303cf31ac7\", \"server\": \"8099\", \"farm\": 9, \"title\": \"Ring-gasm #wildgears #spirograph\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28340643121\", \"owner\": \"70238393@N00\", \"secret\": \"dec539b975\", \"server\": \"8552\", \"farm\": 9, \"title\": \"OMG, Aday, Susie & Matt, we need to have a spirograph party!!!\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28314346982\", \"owner\": \"11172166@N04\", \"secret\": \"82ef8ebc4d\", \"server\": \"8749\", \"farm\": 9, \"title\": \"The Bacon Bacon Cheese Burger ($10.50) - All Natural Angus Beef, Bacon, Caramelized Onions, Secret Sauce, Cheddar, Brioche Bun... It was okay. Not going to lie, @popsonsburgers was better...\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27802036364\", \"owner\": \"21729155@N00\", \"secret\": \"f326d83ba0\", \"server\": \"8576\", \"farm\": 9, \"title\": \"Ed Ruscha at the de Young Museum in San Francisco.\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28385721166\", \"owner\": \"50979393@N00\", \"secret\": \"9272a8242f\", \"server\": \"8828\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28385702816\", \"owner\": \"50979393@N00\", \"secret\": \"d9acf4cf99\", \"server\": \"8271\", \"farm\": 9, \"title\": \"Ted Rheingold & Molly Ditmore\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27802671983\", \"owner\": \"50979393@N00\", \"secret\": \"924520f4d7\", \"server\": \"8835\", \"farm\": 9, \"title\": \"Ted Rheingold & Molly Ditmore\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27802655963\", \"owner\": \"50979393@N00\", \"secret\": \"6f2fdccb24\", \"server\": \"8841\", \"farm\": 9, \"title\": \"Ted Rheingold & Molly Ditmore\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28135773240\", \"owner\": \"50979393@N00\", \"secret\": \"3804e75f2a\", \"server\": \"8839\", \"farm\": 9, \"title\": \"Ted Rheingold & Molly Ditmore\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27802617103\", \"owner\": \"50979393@N00\", \"secret\": \"9848d76370\", \"server\": \"8563\", \"farm\": 9, \"title\": \"Molly Ditmore\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28339761371\", \"owner\": \"50979393@N00\", \"secret\": \"a8050f5601\", \"server\": \"8733\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27802589483\", \"owner\": \"50979393@N00\", \"secret\": \"4ac1bdd70d\", \"server\": \"8717\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28135709790\", \"owner\": \"50979393@N00\", \"secret\": \"57ff3d95ca\", \"server\": \"8832\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28339707941\", \"owner\": \"50979393@N00\", \"secret\": \"90bfb1b088\", \"server\": \"8361\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28313611282\", \"owner\": \"50979393@N00\", \"secret\": \"34f7319360\", \"server\": \"8769\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27801524724\", \"owner\": \"50979393@N00\", \"secret\": \"d7866ee80c\", \"server\": \"8811\", \"farm\": 9, \"title\": \"Ted Rheingold\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28313483452\", \"owner\": \"50979393@N00\", \"secret\": \"6022679dc4\", \"server\": \"8069\", \"farm\": 9, \"title\": \"Pinhole Coffee\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27802296433\", \"owner\": \"50979393@N00\", \"secret\": \"1c39601b66\", \"server\": \"7475\", \"farm\": 8, \"title\": \"Pinhole Coffee\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28135469200\", \"owner\": \"91479620@N04\", \"secret\": \"83ca3e536a\", \"server\": \"8597\", \"farm\": 9, \"title\": \"upload\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28339438321\", \"owner\": \"13218583@N00\", \"secret\": \"d84d0db3b5\", \"server\": \"8591\", \"farm\": 9, \"title\": \"#windows #sanfrancisco #tadichgrill\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28313348462\", \"owner\": \"54769054@N03\", \"secret\": \"a0ceaaac54\", \"server\": \"8473\", \"farm\": 9, \"title\": \"Shiva Linga\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28134658660\", \"owner\": \"62107343@N04\", \"secret\": \"1c0deeef1f\", \"server\": \"8684\", \"farm\": 9, \"title\": \"Over the hills\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28384450846\", \"owner\": \"62107343@N04\", \"secret\": \"d1426f70ce\", \"server\": \"7505\", \"farm\": 8, \"title\": \"Alcatraz\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28338569151\", \"owner\": \"69026149@N00\", \"secret\": \"6b8e59ede2\", \"server\": \"8581\", \"farm\": 9, \"title\": \"Like floral popcorn #flyers #bernalheights\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28338522241\", \"owner\": \"19575157@N00\", \"secret\": \"a8b344ee79\", \"server\": \"8546\", \"farm\": 9, \"title\": \"All About the Hat\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28312404052\", \"owner\": \"28622787@N03\", \"secret\": \"e46a04c4a7\", \"server\": \"7736\", \"farm\": 8, \"title\": \"I Value You, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28133894380\", \"owner\": \"122845541@N02\", \"secret\": \"d2f6cccf42\", \"server\": \"8807\", \"farm\": 9, \"title\": \"STREET food statue\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27799494094\", \"owner\": \"30176397@N04\", \"secret\": \"92b90ce4d7\", \"server\": \"8763\", \"farm\": 9, \"title\": \"Had an extremely amazing adventure #hiking the #Sutro #Forest yesterday.  Vibrant colors, rich & full #plantlife, #fog rushing in over the #mountaintops, the #sky raced above me, wind blowing hard from the #oceantrail side as i climbed tree roots to safet\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28416692555\", \"owner\": \"37886999@N00\", \"secret\": \"32199c68a4\", \"server\": \"8755\", \"farm\": 9, \"title\": \"jul 8 • #ブリットニほぼ日\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27800031293\", \"owner\": \"8198029@N03\", \"secret\": \"b934f20823\", \"server\": \"8010\", \"farm\": 9, \"title\": \"Quick stop for #latteart\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28415896275\", \"owner\": \"70238393@N00\", \"secret\": \"4cb7ea6c50\", \"server\": \"8312\", \"farm\": 9, \"title\": \"Wild Gears have arrived #wildgears #ponoko #lasercut #spirographforadults #freakingout\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27798339974\", \"owner\": \"17185003@N03\", \"secret\": \"61175ed59b\", \"server\": \"8364\", \"farm\": 9, \"title\": \"Nonsite (Essen Soil and Mirrors), by Robert Smithson\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28338378656\", \"owner\": \"55716492@N00\", \"secret\": \"6993736d04\", \"server\": \"7551\", \"farm\": 8, \"title\": \"Silver Crest combo\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27756199613\", \"owner\": \"55716492@N00\", \"secret\": \"293a85acd3\", \"server\": \"8493\", \"farm\": 9, \"title\": \"mum's the word at Speakeasy\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"13969081341\", \"owner\": \"94246031@N00\", \"secret\": \"dd4aa1c79e\", \"server\": \"2900\", \"farm\": 3, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27798926313\", \"owner\": \"73218431@N00\", \"secret\": \"ba9bf8fae8\", \"server\": \"8789\", \"farm\": 9, \"title\": \"Day 49 #makingdorecology - #thread and #yarn collection so far. All found in the #PDRA includes natural dyed linen and wool yarn, 6 boxes of #embroidery floss, and cones of pearl cotton. Time to start #quilting ! #recologyair\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131059600\", \"owner\": \"21393146@N07\", \"secret\": \"2d9caf54b6\", \"server\": \"8842\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131058440\", \"owner\": \"21393146@N07\", \"secret\": \"1c9a73d127\", \"server\": \"8443\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057750\", \"owner\": \"21393146@N07\", \"secret\": \"8e5746648b\", \"server\": \"8530\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057580\", \"owner\": \"21393146@N07\", \"secret\": \"6ddb8bd8ff\", \"server\": \"7797\", \"farm\": 8, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057640\", \"owner\": \"21393146@N07\", \"secret\": \"cf6d7fecac\", \"server\": \"8886\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057600\", \"owner\": \"21393146@N07\", \"secret\": \"1a7e83c403\", \"server\": \"8897\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057420\", \"owner\": \"21393146@N07\", \"secret\": \"07e4b68476\", \"server\": \"8714\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057340\", \"owner\": \"21393146@N07\", \"secret\": \"53dc3f24ec\", \"server\": \"8126\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057310\", \"owner\": \"21393146@N07\", \"secret\": \"84934843ed\", \"server\": \"8838\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131057250\", \"owner\": \"21393146@N07\", \"secret\": \"419929f8a7\", \"server\": \"8700\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27798059493\", \"owner\": \"21393146@N07\", \"secret\": \"d902f07f33\", \"server\": \"8476\", \"farm\": 9, \"title\": \"East Bay, Napa, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27798316253\", \"owner\": \"90319864@N00\", \"secret\": \"b9ecebc716\", \"server\": \"7521\", \"farm\": 8, \"title\": \"California2015-16\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28131232700\", \"owner\": \"119200695@N06\", \"secret\": \"ac67e1a2f3\", \"server\": \"8842\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28414141805\", \"owner\": \"119200695@N06\", \"secret\": \"ef467ac1a3\", \"server\": \"8205\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28380474406\", \"owner\": \"30441069@N05\", \"secret\": \"b4b36da5e3\", \"server\": \"8855\", \"farm\": 9, \"title\": \"One of my favorite buildings + a peekaboo bridge.\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28333013171\", \"owner\": \"53631722@N00\", \"secret\": \"d757e6c277\", \"server\": \"8718\", \"farm\": 9, \"title\": \"Yellow Ford\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28128455930\", \"owner\": \"28369035@N05\", \"secret\": \"4769b9f770\", \"server\": \"8715\", \"farm\": 9, \"title\": \"The sneeze\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27794463624\", \"owner\": \"51481409@N06\", \"secret\": \"671075f249\", \"server\": \"8726\", \"farm\": 9, \"title\": \"San Francisco summer. Fog level 0.5.\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28331390021\", \"owner\": \"69295121@N00\", \"secret\": \"bf7ff11fa6\", \"server\": \"8858\", \"farm\": 9, \"title\": \"Enzo wishes you a happy #tongueouttuesday from the comfort of this particularly delicious leather chair! \uD83D\uDC45\uD83D\uDE0B\uD83D\uDC45  #enzothewhippet #cricketthewhippet #whippet\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28305416952\", \"owner\": \"101108169@N08\", \"secret\": \"7847fecc48\", \"server\": \"8450\", \"farm\": 9, \"title\": \"#SanFrancisco #Alcatraz #Port  #clouds\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28354055645\", \"owner\": \"50446746@N02\", \"secret\": \"e07f19281e\", \"server\": \"8663\", \"farm\": 9, \"title\": \"Lady with the Red High Heels\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28376328536\", \"owner\": \"28159514@N06\", \"secret\": \"6841090c6e\", \"server\": \"8770\", \"farm\": 9, \"title\": \"so we came out here to see the sun over San Francisco and then the infamous fog rolled in as we got out of the car. #twinpeaks \uD83C\uDF01\uD83C\uDF01@sarahrillon_mua\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28409603365\", \"owner\": \"28369035@N05\", \"secret\": \"033c16d89a\", \"server\": \"8801\", \"farm\": 9, \"title\": \"I Left My Heart in San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27957393486\", \"owner\": \"139581587@N03\", \"secret\": \"cd9834199a\", \"server\": \"7289\", \"farm\": 8, \"title\": \"Bay View\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27793162253\", \"owner\": \"87078062@N07\", \"secret\": \"87a2c4b4f4\", \"server\": \"8871\", \"farm\": 9, \"title\": \"San Fran Jazz\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28303172382\", \"owner\": \"32409718@N00\", \"secret\": \"5862683dc1\", \"server\": \"8632\", \"farm\": 9, \"title\": \"2016-07-12 The Dickies - Bottom Of The Hill, San Francisco\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28328316391\", \"owner\": \"145161536@N05\", \"secret\": \"34c38de492\", \"server\": \"7754\", \"farm\": 8, \"title\": \"IMAG0019\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27791338023\", \"owner\": \"145161536@N05\", \"secret\": \"a967729acf\", \"server\": \"8293\", \"farm\": 9, \"title\": \"IMAG0018\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28373882266\", \"owner\": \"145161536@N05\", \"secret\": \"4307364fde\", \"server\": \"7731\", \"farm\": 8, \"title\": \"IMAG0080\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27791337453\", \"owner\": \"145161536@N05\", \"secret\": \"21169da70d\", \"server\": \"8792\", \"farm\": 9, \"title\": \"IMAG0090\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28373882076\", \"owner\": \"145161536@N05\", \"secret\": \"6bf9888a1e\", \"server\": \"8120\", \"farm\": 9, \"title\": \"IMAG0093\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27791337153\", \"owner\": \"145161536@N05\", \"secret\": \"429aba4c25\", \"server\": \"8788\", \"farm\": 9, \"title\": \"IMAG0098\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28373881746\", \"owner\": \"145161536@N05\", \"secret\": \"e08e2ca896\", \"server\": \"7785\", \"farm\": 8, \"title\": \"IMAG0100\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27791336783\", \"owner\": \"145161536@N05\", \"secret\": \"96cf745c59\", \"server\": \"8865\", \"farm\": 9, \"title\": \"IMAG0091\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28373881166\", \"owner\": \"145161536@N05\", \"secret\": \"9ae2c6518f\", \"server\": \"8785\", \"farm\": 9, \"title\": \"IMAG0107\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28328314471\", \"owner\": \"145161536@N05\", \"secret\": \"2b855381df\", \"server\": \"8894\", \"farm\": 9, \"title\": \"IMAG0084\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28124023170\", \"owner\": \"41768893@N00\", \"secret\": \"6a923f28f6\", \"server\": \"7658\", \"farm\": 8, \"title\": \"Reasonable standards\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28406599465\", \"owner\": \"61762949@N05\", \"secret\": \"4cb047cdd6\", \"server\": \"8646\", \"farm\": 9, \"title\": \"Going back home i wanna sleep! #driving #tonightsessions #traffick #sanfrancisco #california #usa \uD83D\uDE34\uD83D\uDE95\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28327370881\", \"owner\": \"32747261@N03\", \"secret\": \"6c8b90278d\", \"server\": \"7648\", \"farm\": 8, \"title\": \"#PHISH\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301226332\", \"owner\": \"28484683@N05\", \"secret\": \"84336641d6\", \"server\": \"8678\", \"farm\": 9, \"title\": \"IMG_20160718_213611\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301225262\", \"owner\": \"28484683@N05\", \"secret\": \"3a2166b72c\", \"server\": \"8705\", \"farm\": 9, \"title\": \"IMG_20160718_213603\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301224342\", \"owner\": \"28484683@N05\", \"secret\": \"4b8bebfb6f\", \"server\": \"8515\", \"farm\": 9, \"title\": \"IMG_20160718_213532\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301223042\", \"owner\": \"28484683@N05\", \"secret\": \"9f61a88a56\", \"server\": \"7739\", \"farm\": 8, \"title\": \"IMG_20160718_213506\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301222032\", \"owner\": \"28484683@N05\", \"secret\": \"e98c90dce5\", \"server\": \"8756\", \"farm\": 9, \"title\": \"IMG_20160718_213345\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301220652\", \"owner\": \"28484683@N05\", \"secret\": \"74a751ed61\", \"server\": \"8841\", \"farm\": 9, \"title\": \"IMG_20160718_213244\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301219502\", \"owner\": \"28484683@N05\", \"secret\": \"00c394e6b0\", \"server\": \"7798\", \"farm\": 8, \"title\": \"IMG_20160718_213235\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301218182\", \"owner\": \"28484683@N05\", \"secret\": \"e1ae5c681a\", \"server\": \"8092\", \"farm\": 9, \"title\": \"IMG_20160718_213152\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301216402\", \"owner\": \"28484683@N05\", \"secret\": \"5336aaeba1\", \"server\": \"7651\", \"farm\": 8, \"title\": \"IMG_20160718_213142\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301214902\", \"owner\": \"28484683@N05\", \"secret\": \"12c4328f33\", \"server\": \"8232\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301213542\", \"owner\": \"28484683@N05\", \"secret\": \"9757dc439f\", \"server\": \"8854\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301212152\", \"owner\": \"28484683@N05\", \"secret\": \"49d1a196c3\", \"server\": \"7573\", \"farm\": 8, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301210902\", \"owner\": \"28484683@N05\", \"secret\": \"08f8b6e73e\", \"server\": \"8479\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27789813923\", \"owner\": \"28484683@N05\", \"secret\": \"46e2719f03\", \"server\": \"8130\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27789812773\", \"owner\": \"28484683@N05\", \"secret\": \"abb5511a89\", \"server\": \"8291\", \"farm\": 9, \"title\": \"\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27789811693\", \"owner\": \"28484683@N05\", \"secret\": \"af1b333e71\", \"server\": \"8424\", \"farm\": 9, \"title\": \"IMG_20160718_110353\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301030202\", \"owner\": \"35585156@N00\", \"secret\": \"ea58a47ce1\", \"server\": \"8286\", \"farm\": 9, \"title\": \"IMG_20160715_084654\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28122648850\", \"owner\": \"35585156@N00\", \"secret\": \"f631158e29\", \"server\": \"8186\", \"farm\": 9, \"title\": \"IMG_20160715_084643\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28122644670\", \"owner\": \"35585156@N00\", \"secret\": \"9bdd9c76a1\", \"server\": \"8021\", \"farm\": 9, \"title\": \"IMG_20160715_093846\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28301017182\", \"owner\": \"35585156@N00\", \"secret\": \"441b99e8d7\", \"server\": \"8631\", \"farm\": 9, \"title\": \"IMG_20160715_093850\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"28122641900\", \"owner\": \"35585156@N00\", \"secret\": \"96b129b16d\", \"server\": \"8403\", \"farm\": 9, \"title\": \"IMG_20160715_093854\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 },\n" +
            "      { \"id\": \"27789691833\", \"owner\": \"35585156@N00\", \"secret\": \"689405eb0b\", \"server\": \"8744\", \"farm\": 9, \"title\": \"IMG_20160715_093858\", \"ispublic\": 1, \"isfriend\": 0, \"isfamily\": 0 }\n" +
            "    ] }, \"stat\": \"ok\" }";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textview);

        gson = new Gson();
        final Array array = gson.fromJson(CURRENTLOCATION_JSON, Array.class);
        Log.i("MainActivity", "Array(root) " + array.getStat());
        printJsonString(array);
        


    }

    private void printJsonString (Array array) {
        String jsonString = gson.toJson(array);
        Log.i("Main", jsonString);
    }
}
