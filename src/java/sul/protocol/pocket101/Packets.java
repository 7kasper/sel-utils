/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.protocol.pocket101;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import sul.utils.Packet;

/**
 * Protocol used in Minecraft: Pocket Edition and variants. The network part of the
 * protocol is managed by RakNet.
 * 
 * <h4>Login sequence</h4>
 * + The client sends a Login packet with the details of its game and its account
 * + The server always replies with a PlayerStatus
 * + If status field in the packet sent was different from ok the connection is closed
 * 
 * <h3>Spawning sequence</h3>
 * + The server sends a StartGame packet with the world's informations
 * + The server sends zero or more FullChunkData with the chunk's blocks and tiles
 * + The server sends the player's inventory using ContainerSetContent
 * + The server sends the world's textures through ResourcePacksInfo (the textures
 * may be empty)
 * + The client replies with ResourcePackClientResponse telling the server that the
 * textures have been loaded
 * + The server sends a PlayStatus packet set to spawned
 * + The client spawns
 */
public final class Packets {

	private Packets() {}

	/**
	 * Packets related to the gameplay. Network-related packets (encapsulation, acks, nacks)
	 * are managed by RakNet and every packet in this section is encapsualted in an Encapsualted
	 * packet.
	 */
	public static final Map<Integer, Class<? extends Packet>> PLAY;

	static {

		HashMap<Integer, Class<? extends Packet>> play = new HashMap<Integer, Class<? extends Packet>>();
		play.put(1, sul.protocol.pocket101.play.Login.class);
		play.put(2, sul.protocol.pocket101.play.PlayStatus.class);
		play.put(3, sul.protocol.pocket101.play.ServerToClientHandshake.class);
		play.put(4, sul.protocol.pocket101.play.ClientToServerHandshake.class);
		play.put(5, sul.protocol.pocket101.play.Disconnect.class);
		play.put(6, sul.protocol.pocket101.play.Batch.class);
		play.put(7, sul.protocol.pocket101.play.ResourcePacksInfo.class);
		play.put(8, sul.protocol.pocket101.play.ResourcePacksStackPacket.class);
		play.put(9, sul.protocol.pocket101.play.ResourcePackClientResponse.class);
		play.put(10, sul.protocol.pocket101.play.Text.class);
		play.put(11, sul.protocol.pocket101.play.SetTime.class);
		play.put(12, sul.protocol.pocket101.play.StartGame.class);
		play.put(13, sul.protocol.pocket101.play.AddPlayer.class);
		play.put(14, sul.protocol.pocket101.play.AddEntity.class);
		play.put(15, sul.protocol.pocket101.play.RemoveEntity.class);
		play.put(16, sul.protocol.pocket101.play.AddItemEntity.class);
		play.put(17, sul.protocol.pocket101.play.AddHangingEntity.class);
		play.put(18, sul.protocol.pocket101.play.TakeItemEntity.class);
		play.put(19, sul.protocol.pocket101.play.MoveEntity.class);
		play.put(20, sul.protocol.pocket101.play.MovePlayer.class);
		play.put(21, sul.protocol.pocket101.play.RiderJump.class);
		play.put(22, sul.protocol.pocket101.play.RemoveBlock.class);
		play.put(23, sul.protocol.pocket101.play.UpdateBlock.class);
		play.put(24, sul.protocol.pocket101.play.AddPainting.class);
		play.put(25, sul.protocol.pocket101.play.Explode.class);
		play.put(26, sul.protocol.pocket101.play.LevelSoundEvent.class);
		play.put(27, sul.protocol.pocket101.play.LevelEvent.class);
		play.put(28, sul.protocol.pocket101.play.BlockEvent.class);
		play.put(29, sul.protocol.pocket101.play.EntityEvent.class);
		play.put(30, sul.protocol.pocket101.play.MobEffect.class);
		play.put(31, sul.protocol.pocket101.play.UpdateAttributes.class);
		play.put(32, sul.protocol.pocket101.play.MobEquipment.class);
		play.put(33, sul.protocol.pocket101.play.MobArmorEquipment.class);
		play.put(34, sul.protocol.pocket101.play.Interact.class);
		play.put(35, sul.protocol.pocket101.play.UseItem.class);
		play.put(36, sul.protocol.pocket101.play.PlayerAction.class);
		play.put(37, sul.protocol.pocket101.play.PlayerFall.class);
		play.put(38, sul.protocol.pocket101.play.HurtArmor.class);
		play.put(39, sul.protocol.pocket101.play.SetEntityData.class);
		play.put(40, sul.protocol.pocket101.play.SetEntityMotion.class);
		play.put(41, sul.protocol.pocket101.play.SetEntityLink.class);
		play.put(42, sul.protocol.pocket101.play.SetHealth.class);
		play.put(43, sul.protocol.pocket101.play.SetSpawnPosition.class);
		play.put(44, sul.protocol.pocket101.play.Animate.class);
		play.put(45, sul.protocol.pocket101.play.Respawn.class);
		play.put(46, sul.protocol.pocket101.play.DropItem.class);
		play.put(47, sul.protocol.pocket101.play.InventoryAction.class);
		play.put(48, sul.protocol.pocket101.play.ContainerOpen.class);
		play.put(49, sul.protocol.pocket101.play.ContainerClose.class);
		play.put(50, sul.protocol.pocket101.play.ContainerSetSlot.class);
		play.put(51, sul.protocol.pocket101.play.ContainerSetData.class);
		play.put(52, sul.protocol.pocket101.play.ContainerSetContent.class);
		play.put(53, sul.protocol.pocket101.play.CraftingData.class);
		play.put(54, sul.protocol.pocket101.play.CraftingEvent.class);
		play.put(55, sul.protocol.pocket101.play.AdventureSettings.class);
		play.put(56, sul.protocol.pocket101.play.BlockEntityData.class);
		play.put(57, sul.protocol.pocket101.play.PlayerInput.class);
		play.put(58, sul.protocol.pocket101.play.FullChunkData.class);
		play.put(59, sul.protocol.pocket101.play.SetCommandsEnabled.class);
		play.put(60, sul.protocol.pocket101.play.SetDifficulty.class);
		play.put(61, sul.protocol.pocket101.play.ChangeDimension.class);
		play.put(62, sul.protocol.pocket101.play.SetPlayerGameType.class);
		play.put(63, sul.protocol.pocket101.play.PlayerList.class);
		play.put(64, sul.protocol.pocket101.play.TelemetryEvent.class);
		play.put(65, sul.protocol.pocket101.play.SpawnExperienceOrb.class);
		play.put(66, sul.protocol.pocket101.play.ClientboundMapItemData.class);
		play.put(67, sul.protocol.pocket101.play.MapInfoRequest.class);
		play.put(68, sul.protocol.pocket101.play.RequestChunkRadius.class);
		play.put(69, sul.protocol.pocket101.play.ChunkRadiusUpdated.class);
		play.put(70, sul.protocol.pocket101.play.ItemFrameDropItem.class);
		play.put(71, sul.protocol.pocket101.play.ReplaceSelectedItem.class);
		play.put(72, sul.protocol.pocket101.play.GameRulesChanged.class);
		play.put(73, sul.protocol.pocket101.play.Camera.class);
		play.put(74, sul.protocol.pocket101.play.AddItem.class);
		play.put(75, sul.protocol.pocket101.play.BossEvent.class);
		play.put(76, sul.protocol.pocket101.play.ShowCredits.class);
		play.put(77, sul.protocol.pocket101.play.AvailableCommands.class);
		play.put(78, sul.protocol.pocket101.play.CommandStep.class);
		play.put(79, sul.protocol.pocket101.play.ResourcePackDataInfo.class);
		play.put(80, sul.protocol.pocket101.play.ResourcePackChunkData.class);
		play.put(81, sul.protocol.pocket101.play.ResourcePackChunkRequest.class);
		play.put(82, sul.protocol.pocket101.play.Transfer.class);
		PLAY = Collections.unmodifiableMap(play);

	}

}
