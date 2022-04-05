package at.ealwary.jnrchallenge.util;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

public class RewardUtil {
    private JnrChallenge plugin;
    private ArrayList<ItemStack> rewardsList;

    public RewardUtil(JnrChallenge plugin) {
        this.plugin = plugin;
        rewardsList = new ArrayList<>();

        addRewards();
    }

    public ArrayList<ItemStack> getRewards() {
        return rewardsList;
    }

    public ItemStack getRandomReward() {
        Collections.shuffle(rewardsList);
        return rewardsList.get(0);
    }

    private void addRewards() {
        rewardsList.add(new ItemBuilder(Material.EMERALD_BLOCK).setDisplayName(ID.REWARD_NAME_START + Material.EMERALD_BLOCK.name()).create());
        rewardsList.add(new ItemBuilder(Material.PUMPKIN_PIE).setDisplayName(ID.REWARD_NAME_START + Material.PUMPKIN_PIE.name()).setAmount(14).create());
        rewardsList.add(new ItemBuilder(Material.TROPICAL_FISH_BUCKET).setDisplayName(ID.REWARD_NAME_START + Material.TROPICAL_FISH_BUCKET.name()).create());
        rewardsList.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(ID.REWARD_NAME_START + Material.IRON_BOOTS.name()).addEnchantment(Enchantment.DEPTH_STRIDER, 1).addEnchantment(Enchantment.DURABILITY, 2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).create());
        rewardsList.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(ID.REWARD_NAME_START + Material.IRON_HELMET.name()).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.MENDING, 0).create());
        rewardsList.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName(ID.REWARD_NAME_START + Material.DIAMOND_LEGGINGS.name()).addEnchantment(Enchantment.MENDING, 0).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).create());
        rewardsList.add(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setDisplayName(ID.REWARD_NAME_START + Material.CHAINMAIL_CHESTPLATE.name()).addEnchantment(Enchantment.DURABILITY, 2).create());
        rewardsList.add(new ItemBuilder(Material.SPECTRAL_ARROW).setDisplayName(ID.REWARD_NAME_START + Material.SPECTRAL_ARROW.name()).setAmount(21).create());
        rewardsList.add(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayName(ID.REWARD_NAME_START + "Enchanted Book: Silk Touch I").addEnchantment(Enchantment.SILK_TOUCH, 0).create());
        rewardsList.add(new ItemBuilder(Material.NETHERITE_HOE).setDisplayName(ID.REWARD_NAME_START + Material.NETHERITE_HOE.name()).addEnchantment(Enchantment.DIG_SPEED, 0).create());
        rewardsList.add(new ItemBuilder(Material.IRON_PICKAXE).setDisplayName(ID.REWARD_NAME_START + Material.IRON_PICKAXE.name()).addEnchantment(Enchantment.LUCK, 2).create());
        rewardsList.add(new ItemBuilder(Material.DIAMOND_AXE).setDisplayName(ID.REWARD_NAME_START + Material.DIAMOND_AXE.name()).addEnchantment(Enchantment.DIG_SPEED, 1).create());
        rewardsList.add(new ItemBuilder(Material.DIAMOND_SHOVEL).setDisplayName(ID.REWARD_NAME_START + Material.DIAMOND_SHOVEL.name()).addEnchantment(Enchantment.DIG_SPEED, 3).create());
        rewardsList.add(new ItemBuilder(Material.ENDER_EYE).setDisplayName(ID.REWARD_NAME_START + Material.ENDER_EYE.name()).setAmount(3).create());
        rewardsList.add(new ItemBuilder(Material.PARROT_SPAWN_EGG).setDisplayName(ID.REWARD_NAME_START + Material.PARROT_SPAWN_EGG.name()).create());
        rewardsList.add(new ItemBuilder(Material.FIREWORK_ROCKET).setDisplayName(ID.REWARD_NAME_START + Material.FIREWORK_ROCKET.name()).setAmount(7).create());
        rewardsList.add(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayName(ID.REWARD_NAME_START + "Enchanted Book: Respiration I").addEnchantment(Enchantment.OXYGEN, 0).create());
        rewardsList.add(new ItemBuilder(Material.TRIDENT).setDisplayName(ID.REWARD_NAME_START + Material.TRIDENT.name()).addEnchantment(Enchantment.LOYALTY, 0).create());
        rewardsList.add(new ItemBuilder(Material.TNT).setDisplayName(ID.REWARD_NAME_START + Material.TNT.name()).setAmount(4).create());
        rewardsList.add(new ItemBuilder(Material.TURTLE_EGG).setDisplayName(ID.REWARD_NAME_START + Material.TURTLE_EGG.name()).create());
        rewardsList.add(new ItemBuilder(Material.NETHERITE_SCRAP).setDisplayName(ID.REWARD_NAME_START + Material.NETHERITE_SCRAP.name()).create());
        rewardsList.add(new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayName(ID.REWARD_NAME_START + Material.ENCHANTED_GOLDEN_APPLE.name()).create());
        rewardsList.add(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayName(ID.REWARD_NAME_START + Material.GOLDEN_APPLE.name()).create());
        rewardsList.add(new ItemBuilder(Material.ENDER_PEARL).setDisplayName(ID.REWARD_NAME_START + Material.ENDER_PEARL.name()).setAmount(3).create());
        rewardsList.add(new ItemBuilder(Material.GOLD_BLOCK).setDisplayName(ID.REWARD_NAME_START + Material.GOLD_BLOCK.name()).create());
        rewardsList.add(new ItemBuilder(Material.CREEPER_HEAD).setDisplayName(ID.REWARD_NAME_START + Material.CREEPER_HEAD.name()).create());
        rewardsList.add(new ItemBuilder(Material.TOTEM_OF_UNDYING).setDisplayName(ID.REWARD_NAME_START + Material.TOTEM_OF_UNDYING.name()).create());
        rewardsList.add(new ItemBuilder(Material.BOW).setDisplayName(ID.REWARD_NAME_START + Material.BOW.name()).addEnchantment(Enchantment.ARROW_INFINITE, 0).addEnchantment(Enchantment.ARROW_DAMAGE, 2).create());
        rewardsList.add(new ItemBuilder(Material.DIAMOND_HORSE_ARMOR).setDisplayName(ID.REWARD_NAME_START + Material.DIAMOND_HORSE_ARMOR.name()).create());
        rewardsList.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(ID.REWARD_NAME_START + Material.DIAMOND_SWORD.name()).addEnchantment(Enchantment.DAMAGE_ALL, 2).addEnchantment(Enchantment.DURABILITY, 1).create());
        rewardsList.add(new ItemBuilder(Material.HEART_OF_THE_SEA).setDisplayName(ID.REWARD_NAME_START + Material.HEART_OF_THE_SEA.name()).create());
        rewardsList.add(new ItemBuilder(Material.HONEY_BOTTLE).setDisplayName(ID.REWARD_NAME_START + Material.HONEY_BOTTLE.name()).create());
        rewardsList.add(new ItemBuilder(Material.EXPERIENCE_BOTTLE).setDisplayName(ID.REWARD_NAME_START + Material.EXPERIENCE_BOTTLE.name()).setAmount(6).create());
        rewardsList.add(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayName(ID.REWARD_NAME_START + "Enchanted Book: Looting II").addEnchantment(Enchantment.LOOT_BONUS_MOBS, 1).create());
        rewardsList.add(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayName(ID.REWARD_NAME_START + "Enchanted Book: Soul Speed I").addEnchantment(Enchantment.SOUL_SPEED, 0).create());
        rewardsList.add(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayName(ID.REWARD_NAME_START + "Enchanted Book: Bane ofArthropods III").addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 2).create());
    }
}
