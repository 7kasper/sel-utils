/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.metadata;

import sul.utils.*;

public class Raknet8 extends Packet {

	@Override
	public int length() {
		return 0;
	}

	@Override
	public byte[] encode() {
		throw new MetadataException("Metadata is not supported");
	}

	@Override
	public void decode(byte[] buffer) {
		throw new MetadataException("Metadata is not supported");
	}

}
