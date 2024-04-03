<div align="center">
    <img
        src="/public-assets/cilantro.png"
        alt="cilantro item"
        style="width:15%"
    >
    <br>
    <h1> cilantro-mod: Minecraft Mod with Fabric API </h1>
</div>
A Minecraft mod that adds Cilantro to the game, using the Fabric API.

## Specs
- Requires Fabric API
- For Minecraft 1.20.x
- CC0 License: Do whatever you want with this.
- Language Support: English, Français, Español, 日本語
  - <small>(also Toki Pona and LOLCAT)</small>

## Features
This mod implements the rare crop Cilantro, and Coriander Seeds to grow it.

Cilantro has assorted uses, similar to other crops in the game.

## Obtaining 

### Loot
Coriander Seeds must be found for the first time in one of the following two methods:
- Jungle Temple Chests contain 1-4 Coriander Seeds 45% of the time.
- Sniffer will dig up Coriander Seeds along with their normal sploot 10% of the time.

### Farming
Coriander Seeds can be planted on tilled soil as any other crop. However, the Cilantro crop, mimicking its growth in real life, can only yield Cilantro at young growth stages, and only yield seeds when fully grown. In this implementation, Cilantro Crops have seven growth stages (0-6).

| Growth Stage:   | 0 | 1 | 2 | 3 | 4 | 5 | 6   |
|-----------------|---|---|---|---|---|---|-----|
| Cilantro        | - | 0-1 | 1-2 | 1-4 | 1-5 | 0-1 | -   |
| Coriander Seeds | - | - | - | - | - | - | 1-4 |
| Stick           | - | - | - | - | - | 1 | 1-2 |

## Usage

### Food

Eating Cilantro on its own restores just 1 hunger point. However, for about 10% of players, all foods that include Cilantro also causes a Nausea effect for 20-30 seconds, reflecting the real-life [OR6A2 gene](https://en.wikipedia.org/wiki/OR6A2) which seems to  cause a fraction of the population to be repulsed by the herb. In the mod, this is derived from the player's UUID, and thus will persist across sessions and worlds. 

Additionally, the following food items can be crafted using recipes including Cilantro or Coriander Seeds.

| Food                     | Recipe                                              | Restoration | Saturation | Other Effects               |
|--------------------------|-----------------------------------------------------|-------------|------------|-----------------------------|
| Golden Cilantro          | Cilantro + 8 Gold Nuggets                           | 6           | 1.2        | Strength I                  |
| Salad                    | Bowl + Cilantro + Carrot + Beetroot                 | 5           | 0.6        | -                           |
| Golden Curry Ingredients | Bowl + Coriander Seeds + Potato + Carrot + Raw Beef | 14          | 1.2        | -                           |
| Golden Curry             | Smelt Golden Curry Ingredients*                     | 18          | 1.6        | Absorption II & Strength II |

(You can also craft Golden Curry directly using  Bowl + Coriander Seeds + Baked Potato + Carrot + Steak)

### Animals
Cilantro can be used to lure and breed a variety of mobs:
- Cows/Mooshrooms
- Sheep
- Pigs
- Rabbits
- Goats

Most mobs have a larger affinity for Cilantro than vanilla crops (especially pigs), and will run faster towards the player if they are holding Cilantro.

Cilantro heals 1 hunger point on the following animals, and speeds growth by 30 seconds: 
- Horses/Donkeys
- Llamas

Additionally, Coriander Seeds can be used to lure and breed:
- Chickens
- Sniffers

### Composting
The following items added by the Cilantro mod can be composted in a Composter:

| Item | Composting Chance |
|------| ---|
| Cilantro | 65% |
| Coriander Seeds | 30% |


