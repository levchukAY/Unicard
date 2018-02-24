package by.unicard.unicard.utils;

import android.content.SharedPreferences;

import by.unicard.unicard.UnicardApplication;

public class PreferencesUtils {

    public static final String PREF_IS_LOGGED_IN = "PREF_TASKS_TYPE";

    /*private static final String PREF_TASKS_TYPE = "PREF_TASKS_TYPE";
    public static final int CURRENT_TASKS_TYPE = 0;
    public static final int DONE_TASKS_TYPE = 1;
    public static final int ALL_TASKS_TYPE = 2;

    private static final String DEVICE_TOKEN_KEY = "device_token";
    private static final String DEVICE_TOKEN_DEFAULT = "";

    private static final String ACCOUNT_ID_KEY = "account_id";
    private static final int ACCOUNT_ID_DEFAULT = -1;
    private static final String ACCOUNT_NAME_KEY = "account_name";

    private static final String USER_REGISTERED_KEY = "user_registered";

    private static final String VALIDATION_MESSAGE_TIMESTAMP_KEY = "VALIDATION_MESSAGE_TIMESTAMP_KEY";
    private static final long VALIDATION_MESSAGE_TIMESTAMP_DEFAULT = 0;

    private static final String FIRST_SUGGESTION_SCREEN_SHOWN_KEY = "FIRST_SUGGESTION_SCREEN_SHOWN_KEY";
    private static final String MATCHMAKING_INFO_SCREEN_SHOWN_KEY = "MATCHMAKING_INFO_SCREEN_SHOWN_KEY";
    private static final String MATCHMAKING_PROMPT_SHOWN_KEY = "MATCHMAKING_PROMPT_SHOWN_KEY";
    private static final String SUGGESTION_PROMPT_SHOWN_KEY = "SUGGESTION_PROMPT_SHOWN_KEY";
    private static final String COMMUNITY_MATCHMAKER_FIRST_SUGGESTION_EVENT_LOGGED_KEY = "COMMUNITY_MATCHMAKER_FIRST_SUGGESTION_EVENT_LOGGED_KEY";

    private static final String FIRST_DAILY_FIVE_SCREEN_SHOWN_KEY = "FIRST_DAILY_FIVE_SCREEN_SHOWN_KEY";

    private static final String CUPID_CASH_WITHDRAW_MIN_KEY = "CUPID_CASH_WITHDRAW_MIN_KEY";
    private static final String CUPID_CASH_PER_MATCH_VALUE_KEY = "CUPID_CASH_PER_MATCH_VALUE_KEY";
    private static final String CUPID_CASH_DIRECT_SUGGEST = "CUPID_CASH_DIRECT_SUGGEST";
    private static final String CUPID_CASH_EXTRA_DAILY_PICK = "CUPID_CASH_EXTRA_DAILY_PICK";
    private static final String LAST_FREE_DAILY_PICK_DATE = "LAST_FREE_DAILY_PICK_DATE";
    private static final int CUPID_CASH_LIMITS_DEFAULT = 0;

    private static final String INVITE_FRIENDS_REWARD_MESSAGE_KEY = "INVITE_FRIENDS_REWARD_MESSAGE_KEY";
    private static final String SUCCESS_SUGGESTIONS_COUNT = "SUCCESS_SUGGESTIONS_COUNT";
    private static final int SUCCESS_SUGGESTIONS_COUNT_DEFAULT = 0;

    private static final String MY_ACTIVITY_BADGE_COUNT = "MY_ACTIVITY_BADGE_COUNT";
    private static final int MY_ACTIVITY_BADGE_COUNT_DEFAULT = 0;

    private static final int INVITE_FRIENDS_DIALOG_SHOWING_REQUIREMENT_COUNT_1 = 5;
    private static final int INVITE_FRIENDS_DIALOG_SHOWING_REQUIREMENT_COUNT_2 = 100;*/

    /*public static void saveDeviceToken(String token) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DEVICE_TOKEN_KEY, token);
        editor.apply();
    }

    public static void resetDeviceToken() {
        saveDeviceToken(DEVICE_TOKEN_DEFAULT);
    }

    public static void resetUserRegistered() {
        saveUserRegistrationStatus(false);
    }

    public static String getDeviceToken() {
        SharedPreferences preferences = getPreferences();
        return preferences.getString(DEVICE_TOKEN_KEY, DEVICE_TOKEN_DEFAULT);
    }

    public static boolean isDeviceTokenValid() {
        return !getDeviceToken().equals(DEVICE_TOKEN_DEFAULT);
    }

    public static void saveAccountInfo(int accountId, String accountName,
                                       int cupidCassWithdrawMin, int cupidCashPerMatchValue,
                                       int cupidCashDirectSuggest, int cupidCashExtraDailyPick) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(ACCOUNT_ID_KEY, accountId);
        editor.putString(ACCOUNT_NAME_KEY, accountName);
        editor.putInt(CUPID_CASH_WITHDRAW_MIN_KEY, cupidCassWithdrawMin);
        editor.putInt(CUPID_CASH_PER_MATCH_VALUE_KEY, cupidCashPerMatchValue);
        editor.putInt(CUPID_CASH_DIRECT_SUGGEST, cupidCashDirectSuggest);
        editor.putInt(CUPID_CASH_EXTRA_DAILY_PICK, cupidCashExtraDailyPick);
        editor.apply();
    }

    public static void saveMessages(String inviteFriendsMessage) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(INVITE_FRIENDS_REWARD_MESSAGE_KEY, inviteFriendsMessage);
        editor.apply();
    }

    public static String getInviteFriendsMessage(String defaultValue) {
        return getPreferences().getString(INVITE_FRIENDS_REWARD_MESSAGE_KEY, defaultValue);
    }

    public static int getCupidCashWithdrawMin() {
        return getPreferences().getInt(CUPID_CASH_WITHDRAW_MIN_KEY, CUPID_CASH_LIMITS_DEFAULT);
    }

    public static int getCupidCashPerMatchValue() {
        return getPreferences().getInt(CUPID_CASH_PER_MATCH_VALUE_KEY, CUPID_CASH_LIMITS_DEFAULT);
    }

    public static int getCupidCashDirectSuggest() {
        return getPreferences().getInt(CUPID_CASH_DIRECT_SUGGEST, CUPID_CASH_LIMITS_DEFAULT);
    }

    public static int getCupidCashExtraDailyPick() {
        return getPreferences().getInt(CUPID_CASH_EXTRA_DAILY_PICK, CUPID_CASH_LIMITS_DEFAULT);
    }

    public static int getAccountId() {
        return getPreferences().getInt(ACCOUNT_ID_KEY, ACCOUNT_ID_DEFAULT);
    }

    public static String getAccountName() {
        return getPreferences().getString(ACCOUNT_NAME_KEY, "");
    }

    public static void saveUserRegistered() {
        saveUserRegistrationStatus(true);
    }

    private static void saveUserRegistrationStatus(boolean isRegistered) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(USER_REGISTERED_KEY, isRegistered);
        editor.apply();
    }

    public static boolean isUserRegistered() {
        return isEventPassed(USER_REGISTERED_KEY);
    }

    public static void setPermissionAsked(String permission) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(permission, true);
        editor.apply();
    }

    public static boolean wasPermissionAsked(String permission) {
        return getPreferences().getBoolean(permission, false);
    }

    public static boolean wasFirstSuggestionScreenShown() {
        return isEventPassed(FIRST_SUGGESTION_SCREEN_SHOWN_KEY);
    }

    public static void setFirstSuggestionScreenShown() {
        setEventPassed(FIRST_SUGGESTION_SCREEN_SHOWN_KEY);
    }

    public static boolean wasMatchmakingPromptShown() {
        return isEventPassed(MATCHMAKING_PROMPT_SHOWN_KEY);
    }

    public static void setMatchmakingPromptShown() {
        setEventPassed(MATCHMAKING_PROMPT_SHOWN_KEY);
    }

    public static boolean wasMatchmakingInfoScreenShown() {
        return isEventPassed(MATCHMAKING_INFO_SCREEN_SHOWN_KEY);
    }

    public static void setMatchmakingInfoScreenShown() {
        setEventPassed(MATCHMAKING_INFO_SCREEN_SHOWN_KEY);
    }

    public static boolean wasSuggestionPromptShown() {
        return isEventPassed(SUGGESTION_PROMPT_SHOWN_KEY);
    }

    public static void setSuggestionPromptShown() {
        setEventPassed(SUGGESTION_PROMPT_SHOWN_KEY);
    }

    public static void setValidationMessageTimestamp(long timestamp) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putLong(VALIDATION_MESSAGE_TIMESTAMP_KEY, timestamp);
        editor.apply();
    }

    public static long getValidationMessageTimestamp() {
        return getPreferences().getLong(VALIDATION_MESSAGE_TIMESTAMP_KEY,
                VALIDATION_MESSAGE_TIMESTAMP_DEFAULT);
    }

    public static long getLastFreeDailyPickDate() {
        return getPreferences().getLong(LAST_FREE_DAILY_PICK_DATE, 0);
    }

    public static void setLastFreeDailyPickDate(long time) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putLong(LAST_FREE_DAILY_PICK_DATE, time);
        editor.apply();
    }

    public static void setCommunityMatchmakingFirstSuggestionEventLogged() {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(COMMUNITY_MATCHMAKER_FIRST_SUGGESTION_EVENT_LOGGED_KEY, true);
        editor.apply();
    }

    public static boolean wasCommunityMatchmakingFirstSuggestionEventLogged() {
        return getPreferences().getBoolean(COMMUNITY_MATCHMAKER_FIRST_SUGGESTION_EVENT_LOGGED_KEY, false);
    }

    public static boolean wasFirstDailyFiveScreenShown() {
        return isEventPassed(FIRST_DAILY_FIVE_SCREEN_SHOWN_KEY);
    }

    public static void setFirstDailyFiveScreenShown() {
        setEventPassed(FIRST_DAILY_FIVE_SCREEN_SHOWN_KEY);
    }

    public static void saveSuccessSugestionsCount(int count) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SUCCESS_SUGGESTIONS_COUNT, count);
        editor.apply();
    }

    public static int getSuccessSuggestionsCount() {
        return getPreferences().getInt(SUCCESS_SUGGESTIONS_COUNT, SUCCESS_SUGGESTIONS_COUNT_DEFAULT);
    }

    public static boolean isNeedToShowInviteDialog() {
        return getSuccessSuggestionsCount() == INVITE_FRIENDS_DIALOG_SHOWING_REQUIREMENT_COUNT_1 ||
                getSuccessSuggestionsCount() % INVITE_FRIENDS_DIALOG_SHOWING_REQUIREMENT_COUNT_2 == 0;
    }

    public static void saveMyActivityBadgeCount(int count) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(MY_ACTIVITY_BADGE_COUNT, count);
        editor.apply();
    }

    public static int getMyActivityBadgeCount() {
        return getPreferences().getInt(MY_ACTIVITY_BADGE_COUNT, MY_ACTIVITY_BADGE_COUNT_DEFAULT);
    }

    public static int getTasksType() {
        return getPreferences().getInt(PREF_TASKS_TYPE, CURRENT_TASKS_TYPE);
    }

    public static void setTasksType(int tasksType) {
        getPreferences().edit().putInt(PREF_TASKS_TYPE, tasksType).apply();
    }*/

    public static boolean isEventPassed(String eventKey) {
        return getPreferences().getBoolean(eventKey, false);
    }

    public static void setEventPassed(String eventKey) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(eventKey, true);
        editor.apply();
    }

    private static SharedPreferences getPreferences() {
        return UnicardApplication.getApplicationPreferences();
    }
}
