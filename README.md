# Nomad Games — a Minecraft mod about Kazakh folk games

A Forge mod for Minecraft 1.20 that brings **asyk** into the game. Asyk is a traditional Kazakh game played with sheep knucklebones.
It was a course project for Kazakh Language 2 (AITU, group SE-2222), made with a classmate in February 2024.

<p>
  <img src="src/main/resources/assets/nomadgames/textures/item/assyk.png" width="64" alt="asyk item">
  <img src="src/main/resources/assets/nomadgames/textures/item/red_assyk.png" width="64" alt="red asyk item">
</p>

## What it adds

- **Asyk, a throwable item.** You hold right-click to charge it, like a bow, then release to throw it. It flies as its own projectile entity with a custom 3D model and renderer, deals damage, and loses durability with each throw.
- **Red asyk**, a second item variant.
- **Loot.** Asyks drop from grass, from sheep and from the spawn bonus chest. This is done with a global loot modifier, not by editing vanilla loot tables.
- **Data generation** for the loot modifiers, and a custom creative-mode tab.

## How it's built

| Part | Where |
|---|---|
| Item registry (`DeferredRegister`) | `item/ModItems.java` |
| Throw logic: charge time, damage, durability | `item/custom/RealAssyk.java` |
| Projectile entity, model, renderer | `entity/` |
| Global loot modifier + datagen | `datagen/` |
| Client/server event wiring | `events/` |

Java 17 · Minecraft Forge 46 · Gradle

## Run it

```sh
./gradlew runClient     # starts Minecraft with the mod loaded
./gradlew build         # jar in build/libs/
```

The Forge MDK setup notes are in [README.txt](README.txt).
