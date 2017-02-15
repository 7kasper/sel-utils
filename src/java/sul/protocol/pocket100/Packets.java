/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.protocol.pocket100;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import sul.utils.Packet;

public final class Packets {

	private Packets() {}

	public static final Map<Integer, Class<? extends Packet>> PLAY;

	static {

		HashMap<Integer, Class<? extends Packet>> play = new HashMap<Integer, Class<? extends Packet>>();
		play.put(1, sul.protocol.pocket100.play.Login.class);
		play.put(2, sul.protocol.pocket100.play.PlayStatus.class);
		play.put(3, sul.protocol.pocket100.play.ServerToClientHandshake.class);
		play.put(4, sul.protocol.pocket100.play.ClientToServerHandshake.class);
		play.put(5, sul.protocol.pocket100.play.Disconnect.class);
		play.put(6, sul.protocol.pocket100.play.Batch.class);
		play.put(7, sul.protocol.pocket100.play.ResourcePacksInfo.class);
		play.put(8, sul.protocol.pocket100.play.ResourcePacksStackPacket.class);
		play.put(9, sul.protocol.pocket100.play.ResourcePackClientResponse.class);
		play.put(10, sul.protocol.pocket100.play.Text.class);
		play.put(11, sul.protocol.pocket100.play.SetTime.class);
		play.put(12, sul.protocol.pocket100.play.StartGame.class);
		play.put(13, sul.protocol.pocket100.play.AddPlayer.class);
		play.put(14, sul.protocol.pocket100.play.AddEntity.class);
		play.put(15, sul.protocol.pocket100.play.RemoveEntity.class);
		play.put(16, sul.protocol.pocket100.play.AddItemEntity.class);
		play.put(17, sul.protocol.pocket100.play.AddHangingEntity.class);
		play.put(18, sul.protocol.pocket100.play.TakeItemEntity.class);
		play.put(19, sul.protocol.pocket100.play.MoveEntity.class);
		play.put(20, sul.protocol.pocket100.play.MovePlayer.class);
		play.put(21, sul.protocol.pocket100.play.RiderJump.class);
		play.put(22, sul.protocol.pocket100.play.RemoveBlock.class);
		play.put(23, sul.protocol.pocket100.play.UpdateBlock.class);
		play.put(24, sul.protocol.pocket100.play.AddPainting.class);
		play.put(25, sul.protocol.pocket100.play.Explode.class);
		play.put(26, sul.protocol.pocket100.play.LevelSoundEvent.class);
		play.put(27, sul.protocol.pocket100.play.LevelEvent.class);
		play.put(28, sul.protocol.pocket100.play.BlockEvent.class);
		play.put(29, sul.protocol.pocket100.play.EntityEvent.class);
		play.put(30, sul.protocol.pocket100.play.MobEffect.class);
		play.put(31, sul.protocol.pocket100.play.UpdateAttributes.class);
		play.put(32, sul.protocol.pocket100.play.MobEquipment.class);
		play.put(33, sul.protocol.pocket100.play.MobArmorEquipment.class);
		play.put(34, sul.protocol.pocket100.play.Interact.class);
		play.put(35, sul.protocol.pocket100.play.UseItem.class);
		play.put(36, sul.protocol.pocket100.play.PlayerAction.class);
		play.put(37, sul.protocol.pocket100.play.PlayerFall.class);
		play.put(38, sul.protocol.pocket100.play.HurtArmor.class);
		play.put(39, sul.protocol.pocket100.play.SetEntityData.class);
		play.put(40, sul.protocol.pocket100.play.SetEntityMotion.class);
		play.put(41, sul.protocol.pocket100.play.SetEntityLink.class);
		play.put(42, sul.protocol.pocket100.play.SetHealth.class);
		play.put(43, sul.protocol.pocket100.play.SetSpawnPosition.class);
		play.put(44, sul.protocol.pocket100.play.Animate.class);
		play.put(45, sul.protocol.pocket100.play.Respawn.class);
		play.put(46, sul.protocol.pocket100.play.DropItem.class);
		play.put(47, sul.protocol.pocket100.play.InventoryAction.class);
		play.put(48, sul.protocol.pocket100.play.ContainerOpen.class);
		play.put(49, sul.protocol.pocket100.play.ContainerClose.class);
		play.put(50, sul.protocol.pocket100.play.ContainerSetSlot.class);
		play.put(51, sul.protocol.pocket100.play.ContainerSetData.class);
		play.put(52, sul.protocol.pocket100.play.ContainerSetContent.class);
		play.put(53, sul.protocol.pocket100.play.CraftingData.class);
		play.put(54, sul.protocol.pocket100.play.CraftingEvent.class);
		play.put(55, sul.protocol.pocket100.play.AdventureSettings.class);
		play.put(56, sul.protocol.pocket100.play.BlockEntityData.class);
		play.put(57, sul.protocol.pocket100.play.PlayerInput.class);
		play.put(58, sul.protocol.pocket100.play.FullChunkData.class);
		play.put(59, sul.protocol.pocket100.play.SetCommandsEnabled.class);
		play.put(60, sul.protocol.pocket100.play.SetDifficulty.class);
		play.put(61, sul.protocol.pocket100.play.ChangeDimension.class);
		play.put(62, sul.protocol.pocket100.play.SetPlayerGameType.class);
		play.put(63, sul.protocol.pocket100.play.PlayerList.class);
		play.put(64, sul.protocol.pocket100.play.TelemetryEvent.class);
		play.put(65, sul.protocol.pocket100.play.SpawnExperienceOrb.class);
		play.put(66, sul.protocol.pocket100.play.ClientboundMapItemData.class);
		play.put(67, sul.protocol.pocket100.play.MapInfoRequest.class);
		play.put(68, sul.protocol.pocket100.play.RequestChunkRadius.class);
		play.put(69, sul.protocol.pocket100.play.ChunkRadiusUpdated.class);
		play.put(70, sul.protocol.pocket100.play.ItemFrameDropItem.class);
		play.put(71, sul.protocol.pocket100.play.ReplaceSelectedItem.class);
		play.put(72, sul.protocol.pocket100.play.GameRulesChanged.class);
		play.put(73, sul.protocol.pocket100.play.Camera.class);
		play.put(74, sul.protocol.pocket100.play.AddItem.class);
		play.put(75, sul.protocol.pocket100.play.BossEvent.class);
		play.put(76, sul.protocol.pocket100.play.ShowCredits.class);
		play.put(77, sul.protocol.pocket100.play.AvailableCommands.class);
		play.put(78, sul.protocol.pocket100.play.CommandStep.class);
		play.put(79, sul.protocol.pocket100.play.ResourcePackDataInfo.class);
		play.put(80, sul.protocol.pocket100.play.ResourcePackChunkData.class);
		play.put(81, sul.protocol.pocket100.play.ResourcePackChunkRequest.class);
		PLAY = Collections.unmodifiableMap(play);

	}

}
