<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the website, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * Database settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://developer.wordpress.org/advanced-administration/wordpress/wp-config/
 *
 * @package WordPress
 */

// ** Database settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'wp01' );

/** Database username */
define( 'DB_USER', 'wp00' );

/** Database password */
define( 'DB_PASSWORD', 'wp01' );

/** Database hostname */
define( 'DB_HOST', 'localhost' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         'd;]i;@5O7;nfSj03^N3 Pz{a-c2(ue;|lP>zPKQ,-lV(T[H:DY8@oP>)P5O$>#MC' );
define( 'SECURE_AUTH_KEY',  'BQyM9)?af*=~(/He3^n/:+{9^@9cgJncwrsa;!:0!:)`5Zsji032)v~4)1B^ b1+' );
define( 'LOGGED_IN_KEY',    'VmcB%fe@e:UCIY+4`$M41hrTHUk`3<wd<OWkl%&[($6was4A#X$nG )z.[Q))7@I' );
define( 'NONCE_KEY',        '|Ur=R/mu~h|tZh?+e-nn8O;}%Alv!GL+Q}q!Yrc,2-,/&1oMpcn}Zy${:~FQ]x32' );
define( 'AUTH_SALT',        'OkC{qs!9f4AH|3%{ZNII|S@DT45y:#/<`u9O!3RprqkH9p)@54v=r[l7t61 <4L~' );
define( 'SECURE_AUTH_SALT', '?O%MZ1.z#3Qorrcd?7%5|LDHFN9p0w<:+os[>qGY/&Th]Y/_ut.PF&%MG[*o{#L]' );
define( 'LOGGED_IN_SALT',   'jHm7;x@%Tse?[z;EH_}<%5MpO3arBK1_wA 4`7RFVKVTU|GU$h(AsAKN[Nb&d[Z7' );
define( 'NONCE_SALT',       '@,jh5GCs$9PSb?hOLak#`9r+[1+LJ]C96vynp;|2H,f;jF`0fz7,^J:m=`F[=Qn*' );

/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 *
 * At the installation time, database tables are created with the specified prefix.
 * Changing this value after WordPress is installed will make your site think
 * it has not been installed.
 *
 * @link https://developer.wordpress.org/advanced-administration/wordpress/wp-config/#table-prefix
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://developer.wordpress.org/advanced-administration/debug/debug-wordpress/
 */
define( 'WP_DEBUG', false );

/* Add any custom values between this line and the "stop editing" line. */



/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';
