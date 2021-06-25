# SecretDemo


    public static void main(String[] args) throws ValidationException {
        // user phone number or User's only representation
        String userId = "0x01B1058B10452";
        System.out.println("#User: " + userId);
        
        KeyHandler handler = KeyHandler.build(userId);
        Key key = handler.setKeyLength(1024).getKey();

        System.out.println("#User PrivateKey: ");
        System.out.println(key.getPrivateKey());
        
        System.out.println("#User PublicKey: ");
        System.out.println(key.getPublicKey());
        
        System.out.println("#PrivateKey match PublicKey: ");
        System.out.println(handler.check(key.getPrivateKey(), key.getPublicKey()));
        
        String originalUrl = "https://www.masaki.com/api/v3/pay?accountId=0x0F1258B&money=1500&type=consume";
        System.out.println("#Original Url: ");
        System.out.println(originalUrl);

        String signedUrl = handler.encode(originalUrl, key.getPrivateKey());
        System.out.println("#Signed Url: ");
        System.out.println(signedUrl);

        //Server check signedUrl
        boolean passed = handler.decoce(signedUrl, key.getPublicKey());
        System.out.println("#Url is Safety: " + passed);
        
        String unSafeUrl = "https://www.masaki.com/api/v3/pay?accountId=0x0F3858A&money=5500&type=consume&sign=837412dc854dfdcf873b4510367941ba";
        System.out.println("#Attacked Url: ");
        System.out.println(unSafeUrl);
        
        passed = handler.decoce(unSafeUrl, key.getPublicKey());
        System.out.println("#Url is Safety: " + passed);
    }
