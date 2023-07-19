-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2023 at 08:55 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cookmate`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL,
  `a_name` varchar(50) NOT NULL,
  `a_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`a_id`, `a_name`, `a_password`) VALUES
(1, 'admin', 'admin@123');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(100) NOT NULL,
  `c_image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`c_id`, `c_name`, `c_image`) VALUES
(14, 'south indian', 'images/download (1).jpg'),
(18, 'punjabi', 'images/bdubuibz7ist3fchis8v.jpg'),
(19, 'italian', 'images/italian-food.jpg'),
(20, 'gujrati', 'images/Gujarati-Food-1.jpg'),
(23, 'chinese ', 'images/chinese-food.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `f_id` int(11) NOT NULL,
  `r_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `f_description` varchar(500) NOT NULL,
  `f_rating` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `recipe`
--

CREATE TABLE `recipe` (
  `r_id` int(11) NOT NULL,
  `r_name` varchar(100) NOT NULL,
  `r_image` varchar(1000) NOT NULL,
  `r_ingredients` varchar(2000) NOT NULL,
  `r_instruction` varchar(7000) NOT NULL,
  `c_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recipe`
--

INSERT INTO `recipe` (`r_id`, `r_name`, `r_image`, `r_ingredients`, `r_instruction`, `c_id`) VALUES
(10, 'Masala Dosa', 'images/Masala_Dosa.jpg', '<p><strong>For masla dosa</strong></p><ul><li>2 cup rice</li><li>1/2 cup urad dal</li><li>1 teaspoon salt</li><li>1/4 cup refined oil</li><li>1/2 teaspoon fenugreek seeds</li></ul><p>&nbsp;</p><p><strong>For Filling</strong></p><ul><li>1/2 kilograms potato</li><li>2 medium green chilli</li><li>1 tablespoon mustard seeds</li><li>1/4 teaspoon turmeric</li><li>salt As required</li><li>1 and 1/2 cup onion</li><li>2 tablespoon refined oil</li><li>10 leaves curry leaves</li><li>1/4 cup water</li></ul>', '<p><strong>Step 1 Prepare the batter and ferment overnight</strong></p><p>Masala Dosa is one of the most popular South Indian delicacies. To prepare the batter for Masala Dosa, wash and soak the rice (with fenugreek added into it) and urad dal in separate containers for approximately 6-8 hours. Once the rice and urad dal are soaked well, grind them separately in a mixer using the water in which they were soaked, till the mixture reaches a smooth consistency. Mix the batter of both the ingredients in a bigger container and add salt to it. Combine well and allow it to ferment overnight.</p><p><strong>Step 2 Prepare the potato filling for Masala Dosa</strong></p><p>To prepare the filling of the dosa, heat 2 tbsp oil in a thick-bottomed pan and let the mustard seeds splutter. Then, add sliced onions, curry leaves, green chillies and saute them till the onions turn pink. Then, add a pinch of salt, turmeric powder and mix them well. Now, take the cubed potatoes and add them to the sauteed onions and mix them together. Pour water gradually into the mixture and allow the potatoes to simmer for around 4 minutes. When the mixture is in semi-thick state, turn off the gas and let it rest for a few seconds.</p><p><strong>Step 3 Pan fry your dosa on a dosa tawa</strong></p><p>Now, take a dosa tawa and heat it on low-medium flame. Smear 1 tsp oil on it to prepare the dosa. When the tawa is hot, pour and spread the batter evenly in a circular motion.</p><p><strong>Step 4 Add filling and fold the dosa</strong></p><p>when the colour of dosa edges turns into brown, reduce the flame and sprinkle few drops of oil on the dosa sides and put 2 tablespoons of filling. Fold the dosa. Repeat the process until all the batter and filling is used up. Serve hot Masala Dosa with coconut chutney and sabhar.</p>', 14),
(11, 'Paneer Tikka Masala', 'images/Paneer_Tikka_Masala_.jpg', '<p><i><strong>Paneer Tikka</strong></i></p><ul><li><strong>Paneer</strong>: you can use either homemade or store bought paneer but whatever paneer you use, it should be firm and be able to hold it’s shape. You can find paneer at Indian grocery stores or make it at <a href=\"https://www.cookwithmanali.com/how-to-make-paneer-at-home-homemade-paneer-recipe/\">home</a>.</li><li><strong>Yogurt</strong>: for the marinade, it is best to use thick yogurt. Either use Greek yogurt or if using regular yogurt, use store bought yogurt which tends to be thicker than homemade yogurt. If using homemade yogurt, strain it using a muslin cloth for at least 3 to 4 hours to get rid of all the excess water.</li><li><strong>Spices</strong>: the marinade uses coriander powder, garam masala, two types of chili powder, ginger-garlic and lime juice. You can also use fresh herbs like cilantro, mint.</li></ul><p>&nbsp;</p><p><i><strong>The Masala/Curry</strong></i></p><ul><li><strong>Curry base</strong>: the base is made with onions, tomatoes, ginger and garlic which is quite a staple for most creamy Indian curries. I like using white onion for that sweet, subtle flavor.</li><li><strong>Spices</strong>: this paneer tikka masala recipe uses curry powder which is a mix of spices and is popular in the western world. It’s not so much popular in India actually, in fact I didn’t even know it existed until I moved out of India. If you don’t have it, you can use a blend of coriander, cumin, turmeric and ginger.</li><li><strong>Flavor enhancers</strong>: to make the curry creamy, we finish the recipe with butter, cream and cilantro!</li></ul>', '<p><strong>step 1</strong> We will start by making the paneer tikka. To a large bowl, add yogurt (1/3 cup + 1 tablespoon), make sure the yogurt is thick (if using regular homemade yogurt, drain the yogurt for 3 to 4 hours before using in the recipe). To that add the following:</p><ul><li>1 &amp; 1/2 teaspoon ginger-garlic paste</li><li>1 teaspoon coriander powder</li><li>1/2 teaspoon garam masala</li><li>1/2 teaspoon Kashmiri red chili powder</li><li>1/4 teaspoon red chili powder</li><li>1/4 teaspoon salt</li><li>juice of 1/2 lime</li></ul><p>&nbsp;</p><p><strong>step 2-</strong> Using a spatula or whisk, mix until all the ingredients are well combined.</p><p><strong>step 3- </strong>Now add 225 grams paneer (cubed into big cubes), 1 medium red onion (quartered and separated into petals) and 1 medium green pepper (cut into 1 inch cubes).</p><p><strong>step 4-</strong> Mix until the paneer, onion and peppers are well coated with the marinade. You can use your hands here. Cover the bowl and refrigerate for 30 minutes at the least.</p><p><strong>step 5-</strong> Meanwhile, let’s work the curry part of this recipe. Heat 1 tablespoon oil and 1 tablespoon butter in a pan on medium heat. Once hot, add 1/2 teaspoon cumin seeds and 1-inch cinnamon stick.</p><p><strong>step 6-</strong> Let the seeds sizzle and then add 1 large white onion (roughly chopped), 3 to 4 large garlic cloves, chopped and 1-inch chopped ginger.</p><p><strong>step 7-</strong> Stir and cook for around 5 to 6 minutes until onions turn light golden brown in color, stir often in between.</p><p><strong>step 8-</strong> Then add 3 large tomatoes (chopped) along with the following:</p><ul><li>1&amp; 1/2 teaspoon curry powder</li><li>1/2 teaspoon Kashmiri red chili powder</li><li>3/4 teaspoon salt, or to taste</li><li>1 tablespoon sugar</li></ul><p><strong>step&nbsp;9-</strong> Stir and cook the tomatoes for 7 to 8 minutes until soft and completely cooked. This step is important so do not rush this step.</p><p><strong>step&nbsp;10-</strong> Once the tomatoes are completely cooked, remove the pan from heat. Let it cool down a bit and then remove the cinnamon stick and transfer everything to a blender and blend to a fine paste. Set this aside.</p><p><strong>step&nbsp;11-</strong> Back to the tikka now, take the marinated paneer out of the refrigerator. Now, you can cook this in a pan or grill or in your oven. I have used a grill pan that I had. Spray the pan with oil and then add the marinated paneer, onions and bell peppers on the pan.</p><p><strong>step&nbsp;12-</strong> Cook until the paneer turns light golden brown in color and onions and peppers are slightly cooked, turning them few times in between for even cooking. Now it’s time to bring the curry together.</p><p><strong>step&nbsp;13-</strong> Now put the pan back on medium heat and add the pureed paste to it that we had prepared earlier. You can also add remaining 1/4 teaspoon Kashmiri red chili powder at this point if you prefer a brighter color of the curry.</p><p><strong>step&nbsp;14-</strong> Add 1 cup water (or more depending on how much gravy you want), and stir well. Then add remaining 1 tablespoon butter, 2 to 3 tablespoons cream and 1 to 2 tablespoons chopped cilantro. Mix and let it cook for 2 minutes.</p><p><strong>step&nbsp;15-</strong> Add the roasted paneer, onions and peppers into the curry.</p><p><strong>step&nbsp;16-</strong> Mix well and let it simmer for 2 to 3 minutes. Garnish with more cilantro and serve paneer tikka masala with naan or paratha.</p>', 18),
(12, 'Idli Sambhar (Kerala style)', 'images/idli_sambar_karela.jpg', '<h4>For Kerala Sambar:</h4><ul><li>1 Cup Arhar Dal</li><li>1 Small Onion thin sliced</li><li>1 to 2 Pinch Hing</li><li>8 to 10 Lady Finger</li><li>5 to 7 Brinjals</li><li>2 small-sized tomatoes</li><li>A handful of curry leaves</li><li>Turmeric Powder (As per the taste)</li><li>1/2 cup tamarind Pulp (Soak tamarind pulp in a hot cup of water. After 1-2 hours, apply<br>pressure so that the tamarind juice comes out of that pulp)</li><li>2 tbsp of jaggery powder</li><li>2.5 – 3 cups of water</li><li>Salt to taste</li></ul><h4>For Kerala Sambar Temper:</h4><ul><li>2 tablespoon of regular cooking oil</li><li>1 teaspoon mustard seeds</li><li>1 teaspoon urad seeds</li><li>A handful of curry leaves</li><li>2 to 3 dry red chilies</li></ul>', '<h4><strong>To make Kerala Idli Sambar:</strong></h4><ul><li>Pressure cook the arhar dal till it is soft and completely cooked.</li><li>Heat oil and add hing and curry leaves. Let both of them splatter.</li><li>Add onion, ladyfinger, brinjal, and tomatoes (In the same order as mentioned).</li><li>Let all of them fry.</li><li>Add turmeric and salt, cover and let them fry.</li><li>Add the sambar masala powder. Keep frying till the raw smell of masala goes away.</li><li>Add tamarind pulp and jaggery powder. Let it cook for another 3-5 minutes.</li><li>Finally, add the pressure cook dal.</li><li>Cover and let it cook for a good 8-10 minutes.</li><li>You can adjust the water as per the sambar consistency you desire.</li></ul><h4><strong>To Temper the Kerala Idli Sambar:</strong></h4><ul><li>Heat oil in a tempering pan.</li><li>Add mustard seeds, urad dal, hing, and curry leaves.</li><li>Let all of them splatter for a few seconds.</li><li>Transfer the temper into the Kerala sambar idli pan and let the aromas dissolve for a good<br>5-7 minutes.</li><li>Your tasty Kerala Idli Sambar is ready. This is one of the easiest and different idli sambar recipes<br>where you can enjoy the authenticity of Kerala Idli Sambar.</li></ul>', 14),
(13, 'Mendu Vada', 'images/medu-vada-recipe-1.jpg', '<ul><li>1 cup urad dal</li><li>1 tablespoon chopped curry leaves</li><li>1 teaspoon finely chopped green chillies</li><li>1 teaspoon finely chopped ginger</li><li>1 pinch asafoetida</li><li>½ teaspoon cumin seeds</li><li>½ teaspoon lightly crushed black pepper – can use whole peppercorns as well. The addition of black pepper gives a good taste but is optional.</li><li>½ teaspoon salt or as required</li><li>salt as per taste.</li></ul><p><strong>Optional</strong></p><ul><li>⅓ cup finely chopped onions or shallots;&nbsp;</li><li>2 tablespoons of chopped coriander leaves</li><li>&nbsp;¼ cup chopped fresh coconut pieces.</li></ul>', '<h4><i><strong>Soak Lentils</strong></i></h4><p><strong>step 1.</strong> Rinse 1 cup urad dal (husked and split or whole black gram) a few times in water. Then soak the lentils in 2.5 to 3 cups water for at least 4 to 5 hours or up to overnight.</p><p><strong>step 2.</strong> Drain and discard the water. Add the soaked urad dal to a grinder jar. Add 3 to 4 tablespoons fresh water or as needed. Just be sure not to make the batter too thin!</p><p>Do not add too much water while grinding. The batter should be like a soft moist dough but yet light and fluffy.</p><p>It should end up looking like a cake batter rather than a crepe batter.<i> I recommend blending in steps and adding water as needed to achieve the right consistency.</i></p><h4><i><strong>Make Urad Dal Batter</strong></i></h4><p><i><strong>step 3.</strong> Begin to grind or blend the urad dal to a smooth batter. The batter should be fluffy and thick.</i></p><p><strong>step 4.</strong> Continue to grind at intervals by scraping the sides with a spatula. <i>If your mixer or grinder becomes hot, then wait for a few minutes until it cools down.</i></p><p><i><strong>step 5.</strong> Continue to grind or blend until you achieve a smooth, fluffy batter. Remember there should be no fine grits or chunks of urad dal in the batter.</i></p><p><i><strong>step 6.</strong> Remove the batter into a big bowl or vessel. Then briskly whip with a spatula, spoon or a wired whisk for 2 to 3 minutes. This aerates the batter and gives it a light, fluffy texture.</i></p><p><i><strong>step 7.</strong> In the below photo you see the vada batter that has been aerated by continuously whisking it for few minutes.</i></p><h4><i><strong>Check Batter Consistency</strong></i></h4><p><strong>step 8.</strong> A quick way to check the perfect and right consistency of the batter is to add a small spoon of it in a bowl of water. The batter should float and remain intact. If it floats and does not get dissolved, then you have achieved the right consistency.&nbsp;</p><p>If it sinks, this means that your batter is not fluffy enough (with not enough air bubbles trapped in it) or is too thin.</p><p>If the batter is too thin, then add some semolina (fine rava or suji) or urad dal flour or rice flour to it to help thicken it up. Rava or suji also helps in giving a crispy texture to the vada.</p><p><strong>step 9.</strong> Measure and keep all the ingredients ready for making the batter. To the batter, add the following spices and herbs:</p><ul><li>1 tablespoon chopped curry leaves</li><li>1 teaspoon finely chopped green chillies</li><li>1 teaspoon finely chopped ginger</li><li>1 pinch asafoetida</li><li>½ teaspoon cumin seeds</li><li>½ teaspoon lightly crushed black pepper – can use whole peppercorns as well. The addition of black pepper gives a good taste but is optional.</li><li>½ teaspoon salt or as required</li></ul><p>You can also add ⅓ cup finely chopped onions or shallots; 2 tablespoons of chopped coriander leaves and ¼ cup chopped fresh coconut pieces.</p><p><strong>step 10.</strong> Mix the batter well with the herbs, spices and salt. <i>You do not have to ferment the batter. You can use it right away.</i> Check the taste of the batter and, if needed, add some salt.</p><h4><i><strong>Shape Batter</strong></i></h4><p><strong>step 11.</strong> Take a bowl of water. Apply some water from the bowl on both your palms. Take some batter in your right palm from the bowl. Give it a round shape by moving it in a circular position in the right hand.</p><p><strong>step 12.</strong> With your thumb make a hole in the center. You can also use banana leaves or zip lock bags to give the medu vada its doughnut shape.</p><p><strong>TIP:</strong> If the batter sticks and you are not able to shape it then add 1 to 2 tablespoons of rice flour to the batter and mix well. This happens if the batter has become slightly thin which means that there is more water in it.&nbsp;</p><h4><i><strong>Fry Medhu Vadai</strong></i></h4><p>13. In a kadai, heat oil over medium heat. Once the oil becomes hot,<strong>&nbsp;</strong>slide the medu&nbsp;vada gently into the hot oil. <i>Be careful here! The oil can sputter and pop over quite a distance, so I recommend wearing an apron and long sleeves to protect your skin and clothes.</i>&nbsp;</p><p><strong>TIP</strong>: If you do not care about the appearance of the doughnut shape of the medu vada, then just drop spoonfuls of the batter directly in the oil.</p><p><strong>step 14.</strong> Once the vada or garelu are slightly golden and the batter has firmed up and looks crispy, then gently turn over with a slotted spoon and continue to fry.</p><p><strong>step 15.</strong>&nbsp;Continue to fry the vada, turning over as needed.</p><p><strong>step 16.</strong> Fry the medhu vadai till crisp and golden.</p><p><strong>step 17.</strong> Once the medhu vadai is crisp and golden, then remove with a slotted spoon to drain the extra oil. Fry the rest of vadai in the same manner.</p><p><strong>step 18.</strong> Drain them on kitchen tissues to remove extra oil. This way shape the vada batter and fry them in hot oil.</p><p><strong>step 19.</strong> Serve Medu Vada&nbsp;or Garelu or Uzhunnu Vada hot or warm with sambar and coconut chutney.&nbsp;Enjoy!</p><p>&nbsp;</p><p>Extra..</p><p>To make sambar vada, you can make any of the sambar varieties I have listed below. Depending on the veggie stock in the kitchen, I make sambar with just one veggie or a mix of various of them.</p><p>Vada and sambar are a match made in heaven, so even if you make your sambar without any veggie, it will still be a joy to eat.</p>', 14),
(14, 'Chole Bhature', 'images/chole-bhature.jpg', '<p><strong>For chole:</strong></p><ul><li>2 cup chickpeas (channas)</li><li>2 tsp oil</li><li>1 Bbay leaf (tej patta)</li><li>1 Cinnamon stick (dalchini)</li><li>3-4 Cloves (laung)</li><li>1 tsp whole pepper corns (sabut kali mirch)</li><li>3 Green cardamom (choti elaichi)</li><li>2 Black cardamom (badi elaichi)</li><li>1 tsp rurmeric powder (haldi)</li><li>1 tsp chili powder (lal mirch powder)</li><li>1 tsp coriander powder (dhaniya powder)</li><li>1 tsp cumin powder (zeera powder)</li><li>1 tsp cumin seeds (zeera)</li><li>1/2 tsp asafoetida (heeng)</li><li>to taste salt</li><li>1 cup onions, chopped</li><li>1 cup tomatoes, chopped</li><li>1 tsp ginger, chopped</li><li>1 tsp garlic, chopped</li><li>1 tsp ajwain</li><li>1 tsp lime juice</li><li>1 green chili, chopped</li><li>1 Tea bag</li><li>1 tbsp butter</li></ul><p>&nbsp;</p><p><strong>For the bhaturas:</strong></p><ul><li>2 cups maida (refined flour)</li><li>1/2 tsp yeast (dissolved for 10 minutes in luke warm water)</li><li>1/2 cup whole wheat flour</li><li>A pinch of salt</li><li>Water (to knead)</li><li>Oil (for frying)</li></ul>', '<h3><strong>Prepare chole:</strong></h3><p><strong>1.</strong>In a pan add oil, bay leaf, cinnamon, cumin seeds, cloves, whole pepper corns, green and black cardamom.</p><p><strong>2.</strong>After it gets brown add chopped onions and saute it. Now add chopped ginger and garlic.</p><p><strong>3.</strong>Followed by turmeric, chili powder, coriander powder, cumin powder, asafoetida and salt, fry the ingredients together well.</p><p><strong>4.</strong>For de--glazing the pan add a little water.</p><p><strong>5.</strong>Now add the chole (soaked overnight and pressure cooked) to the masala.</p><p><strong>6.</strong>After stirring well add tomatoes, little sugar and salt to the chole.</p><p><strong>7.</strong>Now add ajwain, chopped green chilies and water for the base.</p><p><strong>8.</strong>To get the color in the chole, add a tea bag to the masala.</p><p><strong>9.</strong>Simmer the chole gently for an hour and cover it.</p><p><strong>10.</strong>Add lime juice and a dollop of butter to it.</p><p><strong>11.</strong>Garnish the chole with coriander and butter and serve them hot with bhaturas.</p><h3><strong>Prepare the bhaturas:</strong></h3><p><strong>12.</strong>Knead the whole wheat flour, maida and salt together with adequate amount of water.</p><p><strong>13.</strong>Sprinkle the yeast on top. Leave it for 2-3 hours for the yeast to work.</p><p><strong>14.</strong>Divide it into equal portions. Roll out in an oval or round shape.</p><p><strong>15.</strong>Deep fry till golden brown, like a puri.</p><p><strong>16.</strong>Serve.</p>', 18),
(15, 'Dal Makhani', 'images/dal-makhni.jpg', '<ul><li>2 Cups sabut urad dal</li><li>8 cups water</li><li>2 tbsp salt</li><li>1 tbsp ginger, sliced</li><li>2 tbsp butter</li><li>1 tbsp oil</li><li>2 tsp shahi jeera</li><li>1 tsp kasoori meethi</li><li>2 cups tomato puree</li><li>1 tsp chilli powder</li><li>1 tsp sugar</li><li>1/2 cups cream</li><li>for garnishing green chillies (slit lengthwise)</li></ul>', '<p><strong>1.</strong>To the dal, add water, 1 Tbsp salt and ginger. Cook until dal becomes tender.</p><p><strong>2.</strong>In a heavy based pan, heat butter and oil. Add shahi jeera and kasoori methi. When they begin to splutter, add tomato puree, remaining salt, chilli powder and sugar.</p><p><strong>3.</strong>Stir-fry over high flame, till the oil separates.</p><p><strong>4.</strong>Add cooked dal and bring to boil. The consistency should be such that the dal should move around freely when stirred, otherwise add a little water.</p><p><strong>5.</strong>Leave to simmer, uncovered, till well blended. Stir-in cream and once it gets heated through, serve immediately, garnished with green chillies</p>', 18),
(16, 'Amritsari Kulcha', 'images/amritsari-kulcha_.jpg', '<p><strong>For the dough:</strong></p><ul><li>1 kg refined flour</li><li>400 ml water (add more if needed) (kneed all together for pliable dough)</li><li>A pinch of salt (optional)</li><li>100 ml canola oil</li></ul><p><strong>For the filling:</strong></p><ul><li>1 cup onion, chopped</li><li>1/2 kg potatoes (crushed), boiled</li><li>2 tsp ccoriander seeds (crushed), roasted</li><li>2 tsp ginger, chopped</li><li>2-3 green coriander sprigs, chopped</li><li>1 green chilli, chopped</li><li>1 tbsp anaar dana seed (crushed)</li><li>Lemon juice</li></ul>', '<p><strong>1.</strong>Make a semi-firm dough with refined flour, water, salt and keep it covered with moist cloth for 1 hour in a cool place.</p><p><strong>2.</strong>Combine all filling ingredients, except canola oil, and gently fold together. Check seasoning.</p><p><strong>3.</strong>Dab some oil on your fingers and palms. Using them, make small balls (40-50 g each or size of medium potato) from dough and flatten to stuff with filling. Pack flattened dough with filling just enough to stuff and encase well.</p><p><strong>4.</strong>With a rolling pin, flatten wedges again.</p><p><strong>5.</strong>In a medium-hot, non-stick pan, brush wedges with canola oil and cook evenly on both sides. Serve wedges with coriander-mint chutney or curd (optional).</p>', 18),
(17, 'Kadhi Pakodi', 'images/panjabi_kadhi_pakodi_.jpg', '<p><strong>For curry:</strong></p><ul><li>300 gram Gram flour</li><li>500 gram Yogurt</li><li>100 gram Onion</li><li>20 gram Ginger</li><li>5 gram Red chilli powder</li><li>to taste Salt</li><li>3 gram Turmeric</li><li>2 gram Garam masala powder</li><li>200 ml Oil</li><li>1 glass Water</li></ul><p><strong>For tadka:</strong></p><ul><li>2 gram Dry red chilli</li><li>10 gram Ghee</li><li>2 gram Cumin seeds</li><li>2 gram Onion seeds</li><li>Dry fenugreek leaves</li><li>1 gram Green chilli</li></ul><p><strong>For pakodi:</strong></p><ul><li>250 gram Gram flour</li><li>100 gram Onion (medium sized), sliced</li><li>6 Green chilli, sliced</li><li>to taste Salt</li><li>5 gram Red chilli powder</li><li>20 gram Fresh coriander</li><li>3 gram Cumin seeds</li><li>10 gram Coriander seeds</li><li>As required Water</li></ul>', '<h4><strong>Prepare the curry:</strong></h4><p><strong>1.</strong>In a blender add the yogurt, water and blend to mix it well and place it in a bowl.</p><p><strong>2.</strong>Add the gram flour in the blender and fill it with water and blend.</p><p><strong>3.</strong>Heat oil and add the onion till so they get soft, then add the ginger &amp; garlic paste and fry till they get golden on high flame.</p><p><strong>4.</strong>Add the tomatoes, salt, turmeric and red chili powder mix cook on high flame till the oil comes on top.</p><p><strong>5.</strong>Now add gram flour and water mixture along with yogurt and an extra jug of water mix well, wait for a boil and cook on low to medium for 20 to 25 minutes and starts to get thick.</p><h4><strong>Prepare the tadka:</strong></h4><p><strong>1.</strong>Heat ghee in a pan.</p><p><strong>2.</strong>Add the cumin seeds, onion seeds, fenugreek leaves, green chill, dry red chili fry well on high flame and add to kadhi and mix.</p><p><strong>3.</strong>Prepare the pakodi:</p><p><strong>4.</strong>In a bowl add the gram flour, all the spices, onions, green chili add the water slowly and mix it to make medium batter.</p><p><strong>5.</strong>Heat the oil and add the batter and make pakora, fry them on medium flame till golden.</p><p><strong>6.</strong>Remove them and place on kitchen paper roll.</p><p><strong>7.</strong>Then add the pakora in the curry.</p><p><strong>8.</strong>Add the tadka, garam masala and simmer for 3 to 5 minutes.</p><p><strong>9.</strong>Serve the Kadhi Pakora hot.</p>', 18),
(18, 'Margherita Pizza', 'images/margerita cheese pizza .jpg', '<p><strong>For Pizza dough:</strong></p><ul><li>500 gms flour</li><li>Salt</li><li>300 ml tepid Water</li><li>7 gms dried yeast</li><li>1/2 tsp sugar</li><li>30 ml olive oil</li><li>Extra virgin olive oil</li></ul><p><strong>For the topping:</strong></p><ul><li>Passata sauce</li><li>1 cup Mozzarella cheese, grated</li><li>Handful of basil leaves</li><li>Pepper</li><li>Extra virgin olive oil</li></ul>', '<h4><strong>Prepare the pizza dough:</strong></h4><p><strong>1.</strong>Sieve flour with salt and add yeast to tepid water and stir in sugar. Leave aside for 6 to 8 minutes.</p><p><strong>2.</strong>In a mixing bowl, create a well in the middle of the flour mixture and add 100 ml of yeast mixture and 15 ml olive oil.</p><p><strong>3.</strong>Add in the rest of yeast mixture and remaining olive oil.</p><p><strong>4.</strong>Flour the kneading surface so that the dough does not stick.</p><p><strong>5.</strong>Mix together with your fingers till you have a dough. Knead for 10 minutes till you have an elastic, even product.</p><h4><strong>Proving the dough:</strong></h4><p><strong>1.</strong>Place the dough in a bowl and drizzle generously with extra virgin olive oil.</p><p><strong>2.</strong>Cover bowl with cling film and place in a warm area to prove for 50 minutes.</p><p><strong>3.</strong>After the dough is proved, bash the air out and cut into small pieces for individual pizzas.</p><p><strong>4.</strong>Dust the work surface and rolling pin with some flour before rolling out the dough.</p><h4><strong>Prepare the topping:</strong></h4><p><strong>1.</strong>Pre-heat oven at its highest mark and flour your baking tray.</p><p><strong>2.</strong>Now, using a rolling pin, roll out the freshly made pizza dough and place on the tray.</p><p><strong>3.</strong>Spread a thin layer of passata sauce and cover with mozarella cheese and sprinkle basil leaves.</p><p><strong>4.</strong>Put the tray into the oven for 10 to 12 minutes.</p><p><strong>5.</strong>After the pizza is baked remove from the oven and drizzle extra virgin olive oil and some pepper.</p><p><strong>6.</strong>Garnish with fresh basil and cut into slices.</p>', 19),
(19, 'Mango and Coconut Pannacotta', 'images/pannacotta.jpg', '<ul><li>1 Cup ripe mango pulp</li><li>1 cup coconut milk</li><li>1 cup fresh cream</li><li>1 1/2 tbsp vegetarian gelatin</li><li>1/3 cup + 2 Tbsp castor sugar</li><li>Few drops of vanilla essence</li><li>1 ripe mango, peeled</li><li>for garnishing Fresh mint leaves</li></ul>', '<p><br><strong>1.</strong>Take gelatin in a bowl.</p><p><strong>2.</strong>Add 1 tbsp hot water, mix well and let it dissolve completely.</p><p><strong>3.</strong>Heat cream in a deep non-stick pan.</p><p><strong>4.</strong>Add castor sugar and vanilla essence, mix well.</p><p><strong>5.</strong>Bring to a boil.</p><p><strong>6.</strong>Add half the gelatin to mango pulp and remaining to the coconut milk, mix well.</p><p><strong>7.</strong>Add half the cooked cream to mango pulp and remaining to coconut milk, mix well.</p><p><strong>8.</strong>Spread a layer of mango cream into a short glass and refrigerate for 1/2 hour or till set.</p><p><strong>9.</strong>Spread a layer of coconut cream over the mango cream layer and refrigerate for 1/2 hour or till set.</p><p><strong>10.</strong>Repeat both layers once more after each layer sets properly.</p><p><strong>11.</strong>Cut mango into small dices.</p><p><strong>12.</strong>Top pannacotta with mango dices.</p><p><strong>13.</strong>Garnish with mint leaves and serve chilled.</p>', 19),
(20, 'Pasta Con Pomodoro E Basilico', 'images/zucchini-pasta.jpg', '<ul><li>1 Kg red ripe tomatoes, large</li><li>40 ml extra virgin olive oil</li><li>3 garlic cloves (minced), peeled</li><li>Handful fresh basil</li><li>A pinch of red chilly flakes</li><li>1 packet penne (though you could use any pasta here, long, thin, short or tube, as this is a sauce which works well with all the pastas)</li><li>parmesan cheese</li><li>to taste Salt</li></ul>', '<p><strong>1.</strong>Cut the tomatoes in half crosswise and remove most of the seeds, using your fingers. Then quarter the tomatoes.</p><p><strong>2.</strong>Heat the oil in a large skillet, and add garlic and chilly flakes.</p><p><strong>3.</strong>As soon as the garlic gives off its aroma and becomes opaque, add the tomatoes. Cook over high heat until the tomato begins to thicken. Use a wooden spoon to stir and help break the tomato pulp.</p><p><strong>4.</strong>Add the basil, either whole or roughly chopped, and salt. When the sauce is cooked, remove it from the heat and run it through a food processor for a minute.</p><p><strong>5.</strong>Cook the pasta in abundant boiling water, till al dente, and drain.</p><p><strong>6.</strong>Place in a serving bowl with the sauce. Drizzle a little olive oil over the pasta and mix well with the sauce.</p><p><strong>7.</strong>Serve with grated Parmesan cheese.</p>', 19),
(21, 'Macaroni', 'images/macaroni-recipe_.jpg', '<ul><li>garlic</li><li>⅓ cup finely chopped onions (about 1 medium sized onion, finely chopped)</li><li>salt as per taste</li><li>¼ teaspoon black pepper powder</li><li>&nbsp;¼ teaspoon turmeric powder</li><li>&nbsp;¼ teaspoon garam masala powder</li><li>&nbsp;½ teaspoon Kashmiri red chilli powder</li><li>&nbsp;½ teaspoon coriander powder&nbsp;</li><li>½ teaspoon cumin powder</li><li>1.25 to 1.5 cups of mix vegetables like(carrots, green beans, cauliflower, capsicum, baby corn, broccoli, potatoes etc.) Add veggies of your choice.&nbsp;</li></ul>', '<p><strong>A) cooking macaroni</strong><br>1. In a pan, heat 3 cups water and ½ teaspoon salt. Bring it to a boil.</p><p>2. Add 1 heaped cup macaroni or elbow macaroni (125 grams elbow macaroni).</p><p>3. Stir with a fork.</p><p>4. Begin to cook macaroni on medium to medium-high flame.</p><p>5. Cook macaroni till they are al dente – meaning they should have a slight bite to them.</p><p>6. Drain all the water and keep cooked macaroni aside.</p><p><strong>Cooking vegetables</strong></p><p>7. Heat 2 tablespoons oil in a pan. Lower the flame. Add ½ teaspoon minced garlic or finely chopped garlic or 3 to 4 small garlic cloves, minced or finely chopped. You can also add ½ teaspoon ginger-garlic paste instead.</p><p>8. Sauté till the garlic is light brown or till its raw aroma goes away.</p><p>9. Next add ⅓ cup finely chopped onions (about 1 medium sized onion, finely chopped).</p><p>10. Mix well.&nbsp;begin to sauté onions on a medium-low flame stirring often.</p><p>11.&nbsp;saute till the onions become translucent.</p><p>12. Then add 1 cup tightly packed finely chopped tomatoes.</p><p>13. Mix well.</p><p>14. Cover the pan with lid. In between do check when cooking tomatoes.</p><p>15. Cook tomatoes on a low to medium-low flame till they soften and become pulpy.</p><p>16. Now add all the spice powders one by one – ¼ teaspoon black pepper powder, ¼ teaspoon turmeric powder, ¼ teaspoon garam masala powder, ½ teaspoon Kashmiri red chilli powder, ½ teaspoon coriander powder and ½ teaspoon cumin powder.</p><p>17. Mix and sauté the spice powders for some seconds till you get a nice aroma from the spice powders.</p><p>18. Now add 1.25 to 1.5 cups of mix vegetables. Also add ¼ cup green peas. You can add vegetables like carrots, green beans, cauliflower, capsicum, baby corn, broccoli, potatoes etc. Add veggies of your choice. I added baby corn, carrots, green beans, potatoes, capsicum and green peas.</p><p>19. Season with salt as per taste.</p><p>20. Mix very well.</p><p>21. Pour 1 cup of water</p><p>22. Mix again.</p><p>23. Cover the pan with lid.</p><p>24. On a medium-low to medium flame simmer till the vegetables are cooked. In between do check and if the water has become less you can add some more water.</p><h4><strong>Making macaroni pasta</strong></h4><p>25. Once the vegetables are cooked and tender, add the cooked macaroni.&nbsp;some gravy or curry or sauce will be there when you add the pasta.</p><p>26. Mix well.</p><p>27. On a low to medium-low flame simmer for a few more minutes till all the water is absorbed. Stir at intervals.</p><p>28. Lastly add 1 teaspoon mixed dry herbs – basil, thyme, oregano, parsley. You can add dried herbs of your choice or Italian herbs or Italian seasoning or even fresh herbs</p><p>29. Mix again. check the seasonings and add more salt or herbs if required.</p><p>30.&nbsp;<strong>Serve macaroni pasta hot or warm</strong>. you can top with some grated cheddar or vegetarian parmesan cheese or cream before serving. Garnish the pasta with some finely chopped coriander leaves or parsley or any fresh herb of your choice before serving. You can even sprinkle some chili flakes on macaroni pasta before eating.</p>', 19),
(22, 'Khaman Dhokla', 'images/khaman-dhokla-2.jpg', '<ul><li>1.5 cups gram flour (120 grams besan)</li><li>2 teaspoons Eno or fruit salt.</li><li>2 to 3 pinches of turmeric powder</li><li>a generous pinch of asafoetida (skip to make a gluten-free version)</li><li>1.5 tablespoons lemon or lime juice or ⅓ to ½ teaspoon pure citric acid</li><li>1.5 teaspoons ginger paste (crush 1.5 inch ginger and 1.5 teaspoons green chilies in a mortar-pestle)</li><li>1.5 teaspoons green chili paste</li><li>1 tablespoon sugar or add according to taste</li><li>1 teaspoon salt or add as per taste</li></ul>', '<h4><strong>Prep Pan</strong></h4><p>1.&nbsp;Grease a steamer pan with 2&nbsp;to 3 teaspoons oil.</p><h4><strong>Make Batter</strong></h4><p>2.&nbsp;Take 1.5 cups gram flour (120 grams besan) in a mixing bowl or pan. Do use gram flour which has a fine texture.</p><p><strong>TIP:</strong> You can make khaman with chickpea flour as well.</p><p>3. The add the following ingredients:</p><p>4.&nbsp;Add 1 cup water (or more or less as needed) and 1 tablespoon oil to make a thick yet smooth flowing batter. The amount of water needed depends on the quality of flour, so start with 1 cup and add as required. Stir well to combine.</p><p>5. Then add 1 tablespoon rava (semolina). This is entirely optional but adds a good texture to the khaman. Skip rava or semolina for a gluten-free option.</p><p>6.&nbsp;Stir with a whisk to create a smooth, thick batter without any lumps.</p><h4><strong>Consistency of Batter</strong></h4><p>7. The batter should be thick yet flow easily off of the whisk. A quick tip is that if the batter becomes thin, then 1 to 2 tablespoons of gram flour.</p><p>Next bring 2 to 2.5 cups of water to a boil in a steamer pan or electric cooker or pressure cooker. The amount of water to be added depends on the size of the steamer or pressure cooker.</p><p><strong>NOTE:</strong> To know more about the steaming in a pan, cooker and Instant Pot in detail, do read the tips section below.<br>&nbsp;</p><h4><strong>Leaven Khaman Batter</strong></h4><p>9. Next add 2 teaspoons Eno or fruit salt. 2 teaspoons of Eno makes the khaman soft and fluffy. But there is a slightly alkaline taste to Eno.</p><p>If you’re not a fan of this flavor then add only 1.5 teaspoons of Eno. If using baking soda as your leavening agent add ½ teaspoon to ¾ teaspoon.</p><p>10. Stir the eno with the batter briskly and quickly.</p><p>11. The fruit salt should be mixed evenly with the batter. Or else you get uneven texture in the khaman.</p><p>12.&nbsp;The eno will make the batter become frothy, so you need to work quickly to whisk it in thoroughly. Pour the prepared batter into the greased pan.Gently shake so that the batter evens out in the pan.</p><h4><strong>Steam Khaman</strong></h4><p>1. Place the pan in a steamer or electric rice cooker or pressure cooker. The water should already be boiling or hot when you place the pan with the khaman batter. When using a pressure cooker, remove the vent weight/whistle from the lid and cover the cooker tightly with its lid.</p><p>2. Steam for 15 to 20 minutes in an electric rice cooker. If using a pan or pressure cooker or Instant Pot, steam for 12 to 15 minutes on a medium to medium-high heat. In the below photo the khaman is cooked for 17 minutes using an electric rice cooker.</p><p>3.&nbsp;To check the doneness, insert a toothpick. It should come out clean if the khaman is done. If the toothpick has the batter on it, then you need to steam for another minutes or so.</p><p>4.&nbsp;Let the khaman become warm or cool completely. Gently slide a butter knife along the edges to release the khaman from the pan. Place a plate or tray on top of the pan.</p><p>5.&nbsp;Then quickly invert the pan.</p><p>6.&nbsp;If greased well, the khaman will easily slide out onto the plate.</p><p>7.&nbsp;Use a sharp knife to slice the khaman in squares and set aside until ready to temper. Since I used a concave plate, the khaman settled down in the center. This won’t happen if you use a flat plate.</p><h4><strong>Temper Khaman Dhokla</strong></h4><p>1.&nbsp;Tempering is essential to infuse the khaman with flavor and add moisture to the gram flour sponge. To make the temper, first heat 2 tablespoons of oil in a small pan on the stove. Use peanut oil or any neutral-tasting oil.</p><p>2.&nbsp;Add 1 teaspoon of mustard seeds and allow them to crackle.</p><p>3.&nbsp;When the mustard seeds are crackling, add 10 to 12 curry leaves, and, if you like, 1 teaspoon of cumin seeds and 1 teaspoon of chopped green chili.</p><p>4.&nbsp;Stir and then add 2 teaspoon white sesame seeds.</p><p>5.&nbsp;Fry the sesame seeds for some seconds. But don’t brown them or they’ll become bitter.</p><p>6.&nbsp;Next carefully add ⅓ cup of water. You can switch off the heat when adding water.</p><p>7.&nbsp;Then add 2 teaspoons of sugar.</p><p>8.&nbsp;Stir and allow the tempering mixture to come to a boil. Make sure that the sugar is dissolved.</p><p>9.&nbsp;Remove from the heat and immediately pour this tempering mixture evenly on the khaman dhokla so that it seeps through the sliced edges.</p><p>10. Garnish with 2 to 3 tablespoons of chopped coriander leaves and 2 to 3 tablespoons grated coconut, if you like.</p><h4><strong>Serving Suggestions</strong></h4><p>12.&nbsp;Serve the khaman dhokla straight away or you can store it in an airtight box and serve later after an hour. If enjoying khaman later after several hours, then don’t add coconut until ready to eat.</p><p>You can also refrigerate them, and then when ready to serve just sprinkle some water and heat in a microwave for a few seconds until just warmed.</p><h3><strong>What to eat with Khaman</strong></h3><p>The sweet, savory, fluffy cakes pair great with our usual assortment of Indian chutneys like <strong>Papaya Chutney</strong>, <strong>Mint Chutney</strong>, or even <strong>Coriander Chutney</strong>.</p><p>We also like to pair it with <strong>Tamarind Chutney</strong>. You can also serve it as a healthy snack with your evening chai.</p>', 20),
(23, 'Khandvi recipe', 'images/khandvi-recipe26.jpg', '<h4>For Khandvi Batter</h4><ul><li>1 cup besan (gram flour) or 100 grams besan</li><li>¾ cup sour curd, about 150 grams (dairy or vegan curd)</li><li>2.25 cups water, to be mixed with the curd (alternatively you can also use 3 cups sour buttermilk or chaas)</li><li>1 teaspoon ginger + green chili paste, about ½ inch ginger &amp; 1 green chili crushed in a mortar-pestle</li><li>¼ teaspoon turmeric powder</li><li>⅔ teaspoon salt or add as required</li><li>1 pinch asafoetida (hing)</li></ul><h4>For The Filling</h4><ul><li>2 tablespoons fresh grated coconut</li><li>2 tablespoons chopped coriander leaves</li></ul><h4>For The Khandvi Tempering/Seasoning</h4><ul><li>1 tablespoon oil</li><li>8 to 10 curry leaves</li><li>1 teaspoon mustard seeds</li><li>2 teaspoons white sesame seeds</li><li>1 teaspoon green chili , chopped or ½ red chilli powder</li></ul>', '<h4>Making Khandvi Batter</h4><p>Take the yogurt in a bowl. Add water and stir well till smooth.</p><p>Add ginger-green chili paste, turmeric powder, asafoetida and salt.</p><p>If using fresh yogurt, then to add the sourness, add about ½ tsp of lemon juice.</p><p>Add the gram flour or besan. With a wired whisk, keep on stirring and mixing till all the lumps are dissolved and you get a smooth batter. There should be no lumps in the batter. You can also use a hand held beater to mix the batter.</p><p>Spread oil on plates or boards or tray. Large steel lids or thalis work very well. You can also use the back of a large baking tray or your kitchen counter top.</p><p>Also mix the chopped coriander leaves and grated coconut. Keep aside.</p><p>Pour the batter in a sauce pan or a broad frying pan. Switch on the stove top and keep the flame to the lowest. Begin to stir.</p><p>The batter would thicken and keep on thickening. Keep on stirring. Best to use a wooden spatula or a heat proof silicon spatula.</p><p>The batter also should not be allowed to stick at the bottom. So you have to stir continuously.</p><p>Do a plate test when the batter has thickened well.</p><p>Spread a few teaspoons of the batter on a greased plate. Let it cool a bit and then begin to roll. If you are unable to roll, then the batter needs to be cooked more.</p><h4>Making Khandvi Rolls</h4><p>Quickly pour about ½ to ⅔ cup of batter on a large plate and spread thinly &amp; evenly with a spatula. You have to be quick with the remaining batter too. Since even a bit of cooling and the batter becomes likes blob, difficult to spread.</p><p>Allow to cool and then sprinkle the coconut + coriander leaves mixture sparingly. You can also skip this stuffing part and directly garnish with the coconut and coriander once you temper the khandvi rolls.</p><p>Cut into equal sized strips.</p><p>Gently roll each strip tightly. Then place them in a serving tray or plate.if the tray or plate is large, then you will get large rolls. In this case after you finish rolling half, just cut horizontally and make a second roll.</p><p>Arrange the khandvi rolls next to each other or stack them up neatly in a plate or tray.</p><h4>Tempering (Seasoning) For Khandvi</h4><p>Heat oil and crackle the mustard seeds.</p><p>Then add curry leaves, green chilies and fry for a few seconds.</p><p>Add the sesame seeds and when they change color &amp; crackle, pour the hot tempering mixture along with the oil on the khandvi rolls evenly.</p><p>You can garnish it with some more coconut and coriander leaves, if you prefer. <strong>Serve khandvi with </strong>coriander chutney or coriander mint chutney.</p>', 20),
(24, 'Methi Thepla', 'images/thepla-recipe.jpg', '<ul><li>1 cup fenugreek leaves (methi) – tightly packed</li><li>1 cup whole wheat flour – 120 grams</li><li>¼ cup gram flour (besan), 40 grams</li><li>¼ cup pearl millet flour (bajra flour), 40 grams</li><li>¼ cup sorghum flour (jowar flour) or 40 grams</li><li>1 inch ginger – crushed to a paste</li><li>½ to 1 teaspoon chopped green chillies or serrano pepper – crushed to a paste</li><li>½ teaspoon red chili powder or cayenne pepper</li><li>½ teaspoon turmeric powder</li><li>½ teaspoon cumin powder (ground cumin)</li><li>½ teaspoon Coriander Powder (ground coriander)</li><li>¾ teaspoon salt or add as required</li><li>1 tablespoon oil</li><li>4 to 5 tablespoon Curd (yogurt) or water for kneading or add as required</li><li>oil as required for roasting thepla</li></ul>', '<p>a</p>', 20),
(25, 'Veg Hakka Noodles', 'images/noodles_240x180_81520934755.jpg', '<ul><li>Noodles</li><li>1 tsp Salt</li><li>1 tsp Oil</li><li>1 tsp Garlic paste</li><li>1 tsp Ginger paste</li><li>1/2 cup Beans</li><li>1/2 cup Cabbage, chopped</li><li>1/2 cup Carrot, chopped</li><li>1/2 cup Spring onion, chopped</li><li>1/2 cup Capsicum, chopped</li><li>2 tbsp Soy sauce</li><li>2 tbsp Green chilli sauce</li><li>1 tbsp Tomato sauce</li></ul>', '<h4><strong>How to Make Veg Hakka Noodles</strong></h4><p><strong>1.</strong>Boil the noodles in a pan till it starts to simmer.</p><p><strong>2.</strong>Add salt and some oil to the boiling noodles.</p><p><strong>3.</strong>When the noodles start to e a little sticky, drain the excess water and wash them in cold water.</p><p><strong>4.</strong>In another pan, heat about 3 teaspoon of oil.</p><p><strong>5.</strong>Put ginger paste followed by garlic paste. Saute them well till golden brown.</p><p><strong>6.</strong>Now add all the vegetables to the pan.</p><p><strong>7.</strong>Saute them well and add soy sauce, green chilli sauce and tomato sauce.</p><p><strong>8.</strong>Mix them well and now add the boiled noodles to them.</p><p><strong>9.</strong>Mix them thoroughly with the vegetables.</p><p><strong>10.</strong>Serve hot.</p>', 23),
(26, 'Baby Corn Soup', 'images/corn-soup.jpg', '<ul><li>1 cup baby corn-slit into two, lengthwise</li><li>4 cups water</li><li>1 tsp ginger-finely chopped</li><li>1 tsp garlic-finely chopped</li><li>1 tsp green chilies-finely chopped</li><li>1 Tbsp coriander leaves-finely chopped</li><li>2 Tbsp cabbage-finely chopped</li><li>2 Tbsp capsicum-finely chopped</li><li>2 Tbsp mushrooms-finely chopped</li><li>1 tsp pepper</li><li>1 tsp soya sauce</li><li>4 Tbsp cornflour mixed with 1 cup water</li><li>3 Tbsp oil</li><li>Salt as required</li></ul>', '<p><strong>1.</strong>In a pan, stir fry the ginger, garlic, coriander leaves and green chilies for about 2 minutes.</p><p><strong>2.</strong>Add the corn and all the vegetables (except cabbage), pepper, and salt and stir-fry 2-3 times.</p><p><strong>3.</strong>Add the soya sauce, water and salt. Let it boil, reduce the heat and add the cornflour mixed with water and stir constantly till it thickens slightly, then add the cabbage.</p><p><strong>4.</strong>Remove from heat and serve immediately.</p>', 23);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_post_request`
--

CREATE TABLE `tbl_post_request` (
  `action` varchar(100) NOT NULL,
  `post_data` varchar(100) NOT NULL,
  `date_time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_email` varchar(100) NOT NULL,
  `u_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_name`, `u_email`, `u_password`) VALUES
(23, 'abc', 'abc@gmail.com', '$2y$10$Z6rMiHIRFekCZe1hg7RyruJ2Nzz7H7Pbujdc9s4tY2b1KPxrl5ZqO'),
(24, 'mmm', 'mmm@gmail.com', '$2y$10$uLSkAz7.2Q8lUmD69nv.CeEbx.O0IVaHcEq0S1vM2.B6dQSnWe3jO'),
(25, 'mmm', 'mmm@gmail.com', '$2y$10$taMUOPj1mL.MZ8imMlKRlecCckwxcegPorIHxOfEYCMzy65lOVf2q'),
(26, 'mansivinchhi', 'mansivinchhi@gmail.com', '$2y$10$7K8m/AXWaVo4OJg0oUcvz.4Cz/VuJ8nC70eIr9g4Bsah5gzpSbJNW'),
(27, 'qq', 'qq@gmail.com', '$2y$10$I.C7rsNnSlrvMDjeK.twG.qYHoFfK8krXK2v0jGZEMeszJlX.A1WG'),
(28, 'qq', 'qq@gmail.com', '$2y$10$Oyd83hFuUVY.gYR0fDeoguwNaz6.AX7ffIv5ffJpziSu1CGu6tIYe'),
(29, 'mansivinchhi', 'mansivinchhi@gmail.com', '$2y$10$TUjKWwDSCNbrhYvMlm1HCOA8x4vQNSAX.Duku4xg4cEyXkaoEuIA.'),
(30, 'vinchhi', 'vinchhi@gmail.com', '$2y$10$Bwce4CYwGe72kHhTz73ut.7k7.n7cweXzlyT1t1LN9WmU4HzTw7Kq'),
(31, 'vinchhi', 'vinchhi@gmail.com', '$2y$10$OcguUGsfw3/2r.mcVIw22uFH0IcdPFm4Ejj0lWVgrMs7EOcqhT2LO'),
(32, 'niyti', 'niyti@gmai.com', '$2y$10$Vkn6sMihqFkHejVIhCG4ZuD07J97kNrhr9puQshWeKdmhQKTu3aPG'),
(33, 'mansi', 'mansi@gmai.com', '$2y$10$WuAhXBDNXx/vsGBMO6gX8uYjhyrjbPsC0vY.llEee0qmmsLQedk.2'),
(34, 'mansi', 'mansi@gmai.com', '$2y$10$KD9Ihi2osRhXBFwBm.6bxeWwQRqYC3XtRKMR2zra6DIdBigFmX30S'),
(35, 'mansi', 'mansi@gmai.com', '$2y$10$NqiTNx0H58KQblHlkAZe4uL5Y3Q/PLZC/iMnD0ijqUuWhkCHWY2QC'),
(36, 'mansi', 'mansi@gmai.com', '$2y$10$R44Tlnqm9991ZQn8gIY6QeBh4DL2Bg4xpLvxiCrNpZmDrP8XNIlJe'),
(37, 'oo', 'oo@gmail.com', '$2y$10$uS9Jw6vytqxobBwYOzhMXOuqBaukJM8YwSE5uy5HWlxLDU64uFuXu'),
(38, 'oo', 'oo@gmail.com', '$2y$10$RUAyWilraMezhKhQCFGcp.P4w82.Poag5bY3Q/1RE5Uk2A9K3ZpG6'),
(39, 'oo', 'oo@gmail.com', '$2y$10$In8X/WexFE81lhfzS/fxcOQU/k0B5aP3FyZL9h9TdKO1KSKaAEwNi'),
(40, 'oo', 'oo@gmail.com', '$2y$10$zG00ZFU362KljgidV3bAMelYs.iiL9NZr/0PWct97dcZ.knO7fN62'),
(41, 'oo', 'oo@gmail.com', '$2y$10$M/gykSu7A8zDA23sOqLOe.UuUR25drfWTL3XHyk1VRvIUYLv.Yj9a'),
(42, 'oo', 'oo@gmail.com', '$2y$10$TtOUvZEzDVIWzMC5S3ayeuol9ff29hVZ9y4c0Nr3FOS5U6HxStbdG'),
(43, 'oo', 'oo@gmail.com', '$2y$10$knwFO9Vxm7nemaLCUXGQle4Ehbqa5b8JDSQp0BKHf5YoE7HsdWU9.'),
(44, 'oo', 'oo@gmail.com', '$2y$10$a8GsW.uYPIL8aGpkFuYw/.Mk2aqxBNPzCdukh1zLU5oBLp7xt18ua'),
(45, 'oo', 'oo@gmail.com', '$2y$10$X0cNhCJNfUiggVAiHcSZJuoEVdLeEsUgOcfbCM0vzb0p6ukHyVTgu'),
(46, 'oo', 'oo@gmail.com', '$2y$10$LFlZMUQcij/Uia7QuHJ68uJYf166jPfH.Kjds/dMwf3Iw3NoTvB/O'),
(47, 'oo', 'oo@gmail.com', '$2y$10$cAqzkSRMEP05Lbj.ASMfgOdMhtdWExVhzRWAljzrMyoGqO3okIwCG'),
(48, 'oo', 'oo@gmail.com', '$2y$10$gtMe12mbNTmq1jaPBrcKqeOEFGzySMMtDXLQX3/dq.qKwYMl07Ehu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`f_id`),
  ADD KEY `racipe_constrain` (`r_id`),
  ADD KEY `user_contrain` (`u_id`);

--
-- Indexes for table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `categories_constrain` (`c_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1001;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `f_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `racipe_constrain` FOREIGN KEY (`r_id`) REFERENCES `recipe` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_contrain` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `categories_constrain` FOREIGN KEY (`c_id`) REFERENCES `categories` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
