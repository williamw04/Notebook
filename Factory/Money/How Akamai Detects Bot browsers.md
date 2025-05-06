Akamai is a security measure that analyzes traffic data and bot browser's data. It uses ai algorithms to learn and recognize suspicious activities and historical data. It returns and tracks a score, known as the for a given client browser weighing the likely hood incoming traffics client is a bot or not.

Akamai detects bots through analyzing the tls algorithm used by the bot browser, ip reputation, detecting human like behavior like mouse movement etc, and a hidden test.

# IP Reputation
Depending on activity from the traffic an akamai secured website receives, Akamai can choose to blacklist your ip from any future access.

They also do not favor datacenter ip such as isps rather favoring residential ip because they look more natural.

>[!Uncertainty]
>When developing or running a bot application, it's extremely hard to determine whether your current application is triggering some security mechanism or if your IP was banned already meaning the application was already doom from the start.
>
>The only way to really combat this, is a long tedious process of testing measures we as the developer must implement. This includes rotating res proxies everytime, and possibly running the same program multiple times in order to ensure it wasn't an IP thing.


# TLS Reputation

### What is TLS?
It's the algorithms that enable safe communication over the web. Before browsers connect however, they must engage in a TLS handshake [[protocol]] to establish payload formats and rules.

During this handshaking process they exchange and set server exchange information such as cipher suite (encryption methods), TLS Versions and extensions.

## How can TLS be leveraged to detect bots?
This exchange of information can be processed by the security server and form a JA3 fingerprint. This finger print can then be compared to other fingerprints in a databased, comparing against known secure prints and malicious prints.

Some bots are able to create secure TLS  connections, but have incorrect https headers, outdated TLS version, or unnatural browser behavior

Q: What type of unnatural browser behavior?

Solution: Using headless browsers such as playwright and puppeteer can spoof a browser's real TLS sig.


# Detecting Bot Activity
A human using a browser is very unpredictable making it very difficult to predict or find typical predictable bot patterns


To Try List
	- Try to use real browser data/cookies
- Try to make headers look more realistic
- Cycle Resi Data
- Maybe something to do with cookies?

curl -x http://gw.dataimpulse.com823@00fb5169a3acac77e43e__cr.us:b42750c33a38d21:0001 https://bot.sannysoft.com/



