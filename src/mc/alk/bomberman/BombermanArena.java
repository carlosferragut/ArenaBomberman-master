package mc.alk.bomberman;

import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.objects.events.ArenaEventHandler;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class BombermanArena extends Arena{
	static int damage = 20;

	/**
	 * This is how you create customized events.  You specify a method as a @MatchEventHandler
	 * and give it at least one bukkit event as the first argument.  In this case its EntityDamageByEntityEvent
	 * These events will ONLY be called when a match is ongoing
	 * If the event returns a player (in this case it does) then the event only gets called when
	 * 1) match is ongoing
	 * 2) player is still alive in the match
	 *
	 * @param event: Which bukkit event are we listening to
	 */
	@ArenaEventHandler(suppressCastWarnings=true)
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.isCancelled() || !(event instanceof EntityDamageByEntityEvent) ||
				((EntityDamageByEntityEvent)event).getDamager().getType() != EntityType.SNOWBALL)
			return;
		event.setDamage(damage);
	}
}
