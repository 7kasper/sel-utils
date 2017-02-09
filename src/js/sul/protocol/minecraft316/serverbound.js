/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
/** @module sul/protocol/minecraft316/serverbound */

//import Types from 'types';

const Serverbound = {

	TeleportConfirm: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(teleportId=0) {
			this.teleportId = teleportId;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(teleportId);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.TeleportConfirm().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "TeleportConfirm(teleportId: " + this.teleportId + ")";
		}

	},

	TabComplete: class {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(text="", command=false, hasPosition=false, block=0) {
			this.text = text;
			this.command = command;
			this.hasPosition = hasPosition;
			this.block = block;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(text);
			this.writeBool(command);
			this.writeBool(hasPosition);
			this.writeBigEndianLong(block);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.TabComplete().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "TabComplete(text: " + this.text + ", command: " + this.command + ", hasPosition: " + this.hasPosition + ", block: " + this.block + ")";
		}

	},

	ChatMessage: class {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(text="") {
			this.text = text;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(text);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.ChatMessage().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ChatMessage(text: " + this.text + ")";
		}

	},

	ClientStatus: class {

		static get ID(){ return 3; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// action
		static get RESPAWN(){ return 0; }
		static get REQUEST_STATS(){ return 1; }
		static get OPEN_INVENTORY(){ return 2; }

		constructor(action=0) {
			this.action = action;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(action);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.ClientStatus().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ClientStatus(action: " + this.action + ")";
		}

	},

	ClientSettings: class {

		static get ID(){ return 4; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// chat mode
		static get ENABLED(){ return 0; }
		static get COMMANDS_ONLY(){ return 1; }
		static get DISABLED(){ return 2; }

		// displayed skin parts
		static get CAPE(){ return 1; }
		static get JACKET(){ return 2; }
		static get LEFT_SLEEVE(){ return 4; }
		static get RIGHT_SLEEVE(){ return 8; }
		static get LEFT_PANTS(){ return 16; }
		static get RIGHT_PANTS(){ return 32; }
		static get HAT(){ return 64; }

		// main hand
		static get RIGHT(){ return 0; }
		static get LEFT(){ return 1; }

		constructor(language="", viewDistance=0, chatMode=0, chatColors=false, displayedSkinParts=0, mainHand=0) {
			this.language = language;
			this.viewDistance = viewDistance;
			this.chatMode = chatMode;
			this.chatColors = chatColors;
			this.displayedSkinParts = displayedSkinParts;
			this.mainHand = mainHand;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(language);
			this.writeByte(viewDistance);
			this.writeVaruint(chatMode);
			this.writeBool(chatColors);
			this.writeByte(displayedSkinParts);
			this.writeByte(mainHand);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.ClientSettings().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ClientSettings(language: " + this.language + ", viewDistance: " + this.viewDistance + ", chatMode: " + this.chatMode + ", chatColors: " + this.chatColors + ", displayedSkinParts: " + this.displayedSkinParts + ", mainHand: " + this.mainHand + ")";
		}

	},

	ConfirmTransaction: class {

		static get ID(){ return 5; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(window=0, action=0, accepted=false) {
			this.window = window;
			this.action = action;
			this.accepted = accepted;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeByte(window);
			this.writeBigEndianShort(action);
			this.writeBool(accepted);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.ConfirmTransaction().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ConfirmTransaction(window: " + this.window + ", action: " + this.action + ", accepted: " + this.accepted + ")";
		}

	},

	EnchantItem: class {

		static get ID(){ return 6; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(window=0, enchantment=0) {
			this.window = window;
			this.enchantment = enchantment;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeByte(window);
			this.writeByte(enchantment);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.EnchantItem().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "EnchantItem(window: " + this.window + ", enchantment: " + this.enchantment + ")";
		}

	},

	ClickWindow: class {

		static get ID(){ return 7; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(window=0, slot=0, button=0, action=0, mode=0, clickedItem=null) {
			this.window = window;
			this.slot = slot;
			this.button = button;
			this.action = action;
			this.mode = mode;
			this.clickedItem = clickedItem;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeByte(window);
			this.writeBigEndianShort(slot);
			this.writeByte(button);
			this.writeBigEndianShort(action);
			this.writeVaruint(mode);
			this.writeBytes(clickedItem.encode());
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.ClickWindow().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ClickWindow(window: " + this.window + ", slot: " + this.slot + ", button: " + this.button + ", action: " + this.action + ", mode: " + this.mode + ", clickedItem: " + this.clickedItem + ")";
		}

	},

	CloseWindow: class {

		static get ID(){ return 8; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(window=0) {
			this.window = window;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeByte(window);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.CloseWindow().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "CloseWindow(window: " + this.window + ")";
		}

	},

	PluginMessage: class {

		static get ID(){ return 9; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(channel="", data=null) {
			this.channel = channel;
			this.data = data;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(channel);
			this.writeBytes(data);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PluginMessage().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PluginMessage(channel: " + this.channel + ", data: " + this.data + ")";
		}

	},

	UseEntity: class {

		static get ID(){ return 10; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// type
		static get INTERACT(){ return 0; }
		static get ATTACK(){ return 1; }
		static get INTERACT_AT(){ return 2; }

		// hand
		static get MAIN_HAND(){ return 0; }
		static get OFF_HAND(){ return 1; }

		constructor(target=0, type=0, targetPosition={x:0,y:0,z:0}, hand=0) {
			this.target = target;
			this.type = type;
			this.targetPosition = targetPosition;
			this.hand = hand;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(target);
			this.writeVaruint(type);
			this.writeBigEndianFloat(targetPosition.x); this.writeBigEndianFloat(targetPosition.y); this.writeBigEndianFloat(targetPosition.z);
			this.writeVaruint(hand);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.UseEntity().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UseEntity(target: " + this.target + ", type: " + this.type + ", targetPosition: " + this.targetPosition + ", hand: " + this.hand + ")";
		}

	},

	KeepAlive: class {

		static get ID(){ return 11; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(id=0) {
			this.id = id;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(id);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.KeepAlive().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "KeepAlive(id: " + this.id + ")";
		}

	},

	PlayerPosition: class {

		static get ID(){ return 12; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(position={x:0,y:0,z:0}, onGround=false) {
			this.position = position;
			this.onGround = onGround;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
			this.writeBool(onGround);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PlayerPosition().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PlayerPosition(position: " + this.position + ", onGround: " + this.onGround + ")";
		}

	},

	PlayerPositionAndLook: class {

		static get ID(){ return 13; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(position={x:0,y:0,z:0}, yaw=.0, pitch=.0, onGround=false) {
			this.position = position;
			this.yaw = yaw;
			this.pitch = pitch;
			this.onGround = onGround;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
			this.writeBigEndianFloat(yaw);
			this.writeBigEndianFloat(pitch);
			this.writeBool(onGround);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PlayerPositionAndLook().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PlayerPositionAndLook(position: " + this.position + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
		}

	},

	PlayerLook: class {

		static get ID(){ return 14; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(yaw=.0, pitch=.0, onGround=false) {
			this.yaw = yaw;
			this.pitch = pitch;
			this.onGround = onGround;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianFloat(yaw);
			this.writeBigEndianFloat(pitch);
			this.writeBool(onGround);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PlayerLook().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PlayerLook(yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
		}

	},

	Player: class {

		static get ID(){ return 15; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(onGround=false) {
			this.onGround = onGround;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBool(onGround);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.Player().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Player(onGround: " + this.onGround + ")";
		}

	},

	VehicleMove: class {

		static get ID(){ return 16; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(position={x:0,y:0,z:0}, yaw=.0, pitch=.0) {
			this.position = position;
			this.yaw = yaw;
			this.pitch = pitch;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
			this.writeBigEndianFloat(yaw);
			this.writeBigEndianFloat(pitch);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.VehicleMove().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "VehicleMove(position: " + this.position + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ")";
		}

	},

	SteerBoat: class {

		static get ID(){ return 17; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(rightPaddleTurning=false, leftPaddleTurning=false) {
			this.rightPaddleTurning = rightPaddleTurning;
			this.leftPaddleTurning = leftPaddleTurning;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBool(rightPaddleTurning);
			this.writeBool(leftPaddleTurning);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.SteerBoat().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "SteerBoat(rightPaddleTurning: " + this.rightPaddleTurning + ", leftPaddleTurning: " + this.leftPaddleTurning + ")";
		}

	},

	PlayerAbilities: class {

		static get ID(){ return 18; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// flags
		static get CREATIVE_MODE(){ return 1; }
		static get FLYING(){ return 2; }
		static get ALLOW_FLYING(){ return 4; }
		static get INVINCIBLE(){ return 8; }

		constructor(flags=0, flyingSpeed=.0, walkingSpeed=.0) {
			this.flags = flags;
			this.flyingSpeed = flyingSpeed;
			this.walkingSpeed = walkingSpeed;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeByte(flags);
			this.writeBigEndianFloat(flyingSpeed);
			this.writeBigEndianFloat(walkingSpeed);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PlayerAbilities().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PlayerAbilities(flags: " + this.flags + ", flyingSpeed: " + this.flyingSpeed + ", walkingSpeed: " + this.walkingSpeed + ")";
		}

	},

	PlayerDigging: class {

		static get ID(){ return 19; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// status
		static get START_DIGGING(){ return 0; }
		static get CANCEL_DIGGING(){ return 1; }
		static get FINISH_DIGGING(){ return 2; }
		static get DROP_ITEM_STACK(){ return 3; }
		static get DROP_ITEM(){ return 4; }
		static get SHOOT_ARROW(){ return 5; }
		static get FINISH_EATING(){ return 5; }
		static get SWAP_ITEM_IN_HAND(){ return 6; }

		constructor(status=0, position=0, face=0) {
			this.status = status;
			this.position = position;
			this.face = face;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(status);
			this.writeBigEndianLong(position);
			this.writeByte(face);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PlayerDigging().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PlayerDigging(status: " + this.status + ", position: " + this.position + ", face: " + this.face + ")";
		}

	},

	EntityAction: class {

		static get ID(){ return 20; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// action
		static get START_SNEAKING(){ return 0; }
		static get STOP_SNEAKING(){ return 1; }
		static get LEAVE_BED(){ return 2; }
		static get START_SPRINTING(){ return 3; }
		static get STOP_SPRINTING(){ return 4; }
		static get START_HORSE_JUMP(){ return 5; }
		static get STOP_HORSE_JUMP(){ return 6; }
		static get OPEN_HORSE_INVENTORY(){ return 7; }
		static get START_ELYTRA_FLYING(){ return 8; }

		constructor(entityId=0, action=0, jumpBoost=0) {
			this.entityId = entityId;
			this.action = action;
			this.jumpBoost = jumpBoost;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(entityId);
			this.writeVaruint(action);
			this.writeVaruint(jumpBoost);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.EntityAction().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "EntityAction(entityId: " + this.entityId + ", action: " + this.action + ", jumpBoost: " + this.jumpBoost + ")";
		}

	},

	SteerVehicle: class {

		static get ID(){ return 21; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// flags
		static get JUMP(){ return 1; }
		static get UNMOUNT(){ return 2; }

		constructor(sideways=.0, forward=.0, flags=0) {
			this.sideways = sideways;
			this.forward = forward;
			this.flags = flags;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianFloat(sideways);
			this.writeBigEndianFloat(forward);
			this.writeByte(flags);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.SteerVehicle().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "SteerVehicle(sideways: " + this.sideways + ", forward: " + this.forward + ", flags: " + this.flags + ")";
		}

	},

	ResourcePackStatus: class {

		static get ID(){ return 22; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// result
		static get LOADED(){ return 0; }
		static get DECLINED(){ return 1; }
		static get FAILED(){ return 2; }
		static get ACCEPTED(){ return 3; }

		constructor(result=0) {
			this.result = result;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(result);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.ResourcePackStatus().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ResourcePackStatus(result: " + this.result + ")";
		}

	},

	HeldItemChange: class {

		static get ID(){ return 23; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(slot=0) {
			this.slot = slot;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianShort(slot);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.HeldItemChange().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "HeldItemChange(slot: " + this.slot + ")";
		}

	},

	CreativeInventoryAction: class {

		static get ID(){ return 24; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(slot=0, clickedItem=null) {
			this.slot = slot;
			this.clickedItem = clickedItem;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianShort(slot);
			this.writeBytes(clickedItem.encode());
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.CreativeInventoryAction().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "CreativeInventoryAction(slot: " + this.slot + ", clickedItem: " + this.clickedItem + ")";
		}

	},

	UpdateSign: class {

		static get ID(){ return 25; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(position=0, lines=[]) {
			this.position = position;
			this.lines = lines;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianLong(position);
			for(bgluzxm in lines){ this.writeString(lines[bgluzxm]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.UpdateSign().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateSign(position: " + this.position + ", lines: " + this.lines + ")";
		}

	},

	Animation: class {

		static get ID(){ return 26; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// hand
		static get MAIN_HAND(){ return 0; }
		static get OFF_HAND(){ return 1; }

		constructor(hand=0) {
			this.hand = hand;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(hand);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.Animation().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Animation(hand: " + this.hand + ")";
		}

	},

	Spectate: class {

		static get ID(){ return 27; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(player=new Uint8Array(16)) {
			this.player = player;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianLong(player.getLeastSignificantBits()); this.writeBigEndianLong(player.getMostSignificantBits());
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.Spectate().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Spectate(player: " + this.player + ")";
		}

	},

	PlayerBlockPlacement: class {

		static get ID(){ return 28; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// hand
		static get MAIN_HAND(){ return 0; }
		static get OFF_HAND(){ return 1; }

		constructor(position=0, face=0, hand=0, cursorPosition={x:0,y:0,z:0}) {
			this.position = position;
			this.face = face;
			this.hand = hand;
			this.cursorPosition = cursorPosition;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianLong(position);
			this.writeVaruint(face);
			this.writeVaruint(hand);
			this.writeBigEndianFloat(cursorPosition.x); this.writeBigEndianFloat(cursorPosition.y); this.writeBigEndianFloat(cursorPosition.z);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.PlayerBlockPlacement().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "PlayerBlockPlacement(position: " + this.position + ", face: " + this.face + ", hand: " + this.hand + ", cursorPosition: " + this.cursorPosition + ")";
		}

	},

	UseItem: class {

		static get ID(){ return 29; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// hand
		static get MAIN_HAND(){ return 0; }
		static get OFF_HAND(){ return 1; }

		constructor(hand=0) {
			this.hand = hand;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(hand);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Serverbound.UseItem().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UseItem(hand: " + this.hand + ")";
		}

	},

}

//export { Serverbound };
