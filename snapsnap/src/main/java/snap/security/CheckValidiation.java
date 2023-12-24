package snap.security;

public class CheckValidiation {
	public boolean isEmptyOrNull(String str) {
	    return str == null || str.trim().isEmpty();
	}
}
