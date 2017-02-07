/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.protocol.externalconsole1;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import sul.utils.Packet;

/**
 * Protocol used to communicate with external sources using a raw TCP protocol or Web
 * Sockets.
 * 
 * <h2>Features</h2>
 * + Organised remote logs
 * + Execution of remote commands (if the server allows it)
 * + Authentication using password hashing (optional)
 * + Server's resources usage
 * + Support for the hub-node layout
 * 
 * <h2>Connecting</h2>
 * 
 * <h3>Using raw TCP sockets</h3>
 * The raw TCP protocol, also referred as "classic", uses a stream-oriented TCP connection.
 * This means that packets are not prefixed with their length and every packet's length
 * is fixed or can be retrieved at runtime.
 * The connection starts with the client sending the string `classic` encoded as UTF-8
 * to the server, which replies with an AuthCredentials packet and waits for the client
 * to authenticate.
 * 
 * <h3>Using Web Sockets</h3>
 * The websocket protocol uses json packets instead of binary ones (with the keys in
 * snake case) and encodes the arrays of bytes (AuthCredentials.payload and Auth.hash)
 * into strings using base64. The connection is established like every web socket connection
 * and, if successfull, continues with the AuthCredentials packet sent by the server.
 * Example of a connection in javascript:
 * <code>
 * var socket = new WebSocket("example.com:19134");
 * socket.onmessage = function(event){
 *    var json = JSON.parse(event.data);
 *    if(json.hash) console.log("The server requires hash " + json.hash_algorithm);
 *    else console.log("The server doesn't require hashing");
 * }
 * </code>
 * 
 * <h2>Authenticating</h2>
 * After receiving the AuthCredentials packet, the external console, if able to perform
 * authentication, has to send the password or its hash through the Auth packet and
 * waits for a response, given by the Welcome packet. If the server accepts the external
 * console the status in the packet will be "accepted", the additional fields of the
 * Welcome.Accepted packet can be read and the external console can proceed keeping
 * the connection alive, sending commands, receiving logs and other updates.
 * 
 * <h2>Keeping the connection alive</h2>
 * The server may disconnect the external console after a period of inactivity (which
 * shouldn't be shorter than 8 seconds). For this reason the external console needs
 * to send a KeepAlive packet to notify the server that it is still perfectly connected.
 * 
 * <h2>Server's logs</h2>
 * Every time a log is created on the server it sends a ConsoleMessage to the external
 * console that contains informations about when the log was generated, from whom was
 * generated and the log itself.
 * 
 * <h2>Executing commands</h2>
 * If the remoteCommand field in the Welcome.Accepted packet is true, the server allows
 * the execution of commands from the external console. That's done using the Command
 * packet, which has only one field that is the raw command.
 */
public final class Packets {

	private Packets() {}

	/**
	 * Packets used during the authentication process and to exhange the initial server's
	 * informations.
	 */
	public static final Map<Integer, Class<? extends Packet>> LOGIN;

	/**
	 * Packets about the informations and the usage of the server.
	 */
	public static final Map<Integer, Class<? extends Packet>> STATUS;

	/**
	 * Packets regarding the server's console and commands.
	 */
	public static final Map<Integer, Class<? extends Packet>> CONNECTED;

	static {

		HashMap<Integer, Class<? extends Packet>> login = new HashMap<Integer, Class<? extends Packet>>();
		login.put(0, sul.protocol.externalconsole1.login.AuthCredentials.class);
		login.put(1, sul.protocol.externalconsole1.login.Auth.class);
		login.put(2, sul.protocol.externalconsole1.login.Welcome.class);
		LOGIN = Collections.unmodifiableMap(login);

		HashMap<Integer, Class<? extends Packet>> status = new HashMap<Integer, Class<? extends Packet>>();
		status.put(0, sul.protocol.externalconsole1.status.KeepAlive.class);
		status.put(1, sul.protocol.externalconsole1.status.UpdateNodes.class);
		status.put(2, sul.protocol.externalconsole1.status.RequestStats.class);
		status.put(3, sul.protocol.externalconsole1.status.UpdateStats.class);
		STATUS = Collections.unmodifiableMap(status);

		HashMap<Integer, Class<? extends Packet>> connected = new HashMap<Integer, Class<? extends Packet>>();
		connected.put(4, sul.protocol.externalconsole1.connected.ConsoleMessage.class);
		connected.put(5, sul.protocol.externalconsole1.connected.Command.class);
		connected.put(6, sul.protocol.externalconsole1.connected.PermissionDenied.class);
		CONNECTED = Collections.unmodifiableMap(connected);

	}

}
