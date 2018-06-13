package com.brandall.nutter;

import android.content.Context;
import com.faceture.google.play.LoginResponse;
import com.faceture.google.play.PlayClient;
import com.faceture.google.play.PlayClientBuilder;
import com.faceture.google.play.PlaySession;
import com.faceture.google.play.PropertyConsts;
import com.faceture.google.play.domain.SearchResults;
import com.faceture.google.play.domain.Song;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExecuteGoogleMusic {
    static PlayClient playClient;

    public static jx playMusicSearch(Context context, String str) {
        ExecuteGoogleMusic executeGoogleMusic = new ExecuteGoogleMusic();
        executeGoogleMusic.getClass();
        jx jxVar = new jx(executeGoogleMusic);
        playClient = new PlayClientBuilder().create();
        String S = lx.m1380S(context);
        String T = lx.m1381T(context);
        if (T.matches("") || S.matches("")) {
            ls.m1347d("EGM password null");
            jxVar.f1581a.clear();
            jxVar.f1581a.add("error");
            jxVar.f1581a.add(PropertyConsts.PASSWORD);
        } else {
            try {
                LoginResponse login = playClient.login(S, T);
                ls.m1346c("testLogin: " + login.getLoginResult().toString());
                if (login == null || login.getLoginResult().toString().toLowerCase().contains("bad")) {
                    ls.m1347d("EGM password null");
                    jxVar.f1581a.clear();
                    jxVar.f1581a.add("error");
                    jxVar.f1581a.add(PropertyConsts.PASSWORD);
                } else {
                    PlaySession playSession = login.getPlaySession();
                    if (playSession != null) {
                        SearchResults search = playClient.search(str, playSession);
                        if (search != null) {
                            Song song;
                            ArrayList arrayList = (ArrayList) search.getSongs();
                            ArrayList arrayList2 = (ArrayList) search.getArtists();
                            ArrayList arrayList3 = (ArrayList) search.getAlbums();
                            ls.m1344a("albumMatch: " + arrayList3.size() + " : " + arrayList3.toString());
                            ls.m1344a("artistMatch: " + arrayList2.size() + " : " + arrayList2.toString());
                            ls.m1344a("songMatch: " + arrayList.size() + " : " + arrayList.toString());
                            if (!arrayList2.isEmpty()) {
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    song = (Song) it.next();
                                    if (song.getId() != null) {
                                        jxVar.f1581a.add(song.getArtist() + " " + song.getTitle());
                                        jxVar.f1582b.add(playClient.getPlayURI(song.getId(), playSession).toString());
                                    } else {
                                        ls.m1347d("artm.getId null");
                                    }
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                Iterator it2 = arrayList3.iterator();
                                while (it2.hasNext()) {
                                    song = (Song) it2.next();
                                    if (song.getId() != null) {
                                        jxVar.f1581a.add(song.getArtist() + " " + song.getTitle());
                                        jxVar.f1582b.add(playClient.getPlayURI(song.getId(), playSession).toString());
                                    } else {
                                        ls.m1347d("albm.getId null");
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                Iterator it3 = arrayList.iterator();
                                while (it3.hasNext()) {
                                    Song song2 = (Song) it3.next();
                                    if (song2.getId() != null) {
                                        jxVar.f1581a.add(song2.getArtist() + " " + song2.getTitle());
                                        jxVar.f1582b.add(playClient.getPlayURI(song2.getId(), playSession).toString());
                                    } else {
                                        ls.m1347d("songm.getId null");
                                    }
                                }
                            }
                        } else {
                            ls.m1347d("EGM searchResults null");
                            jxVar.f1581a.clear();
                            jxVar.f1581a.add("error");
                            jxVar.f1581a.add("network");
                        }
                    } else {
                        ls.m1347d("EGM playSession null");
                        jxVar.f1581a.clear();
                        jxVar.f1581a.add("error");
                        jxVar.f1581a.add("network");
                    }
                }
            } catch (IOException e) {
                ls.m1347d("EGM IOException");
                e.printStackTrace();
                jxVar.f1581a.clear();
                jxVar.f1581a.add("error");
                jxVar.f1581a.add("network");
            } catch (URISyntaxException e2) {
                ls.m1347d("EGM IOException");
                e2.printStackTrace();
                jxVar.f1581a.clear();
                jxVar.f1581a.add("error");
                jxVar.f1581a.add("network");
            }
        }
        return jxVar;
    }

    public static boolean testLogin(Context context) {
        playClient = new PlayClientBuilder().create();
        String S = lx.m1380S(context);
        String T = lx.m1381T(context);
        if (T.matches("") || S.matches("") || playClient == null) {
            return false;
        }
        try {
            LoginResponse login = playClient.login(S, T);
            ls.m1346c("testLogin: " + login.getLoginResult().toString());
            return !login.getLoginResult().toString().toLowerCase().contains("bad");
        } catch (IOException e) {
            e.printStackTrace();
            ls.m1347d("testLogin: IOException");
            return false;
        } catch (URISyntaxException e2) {
            ls.m1347d("testLogin: URISyntaxException");
            e2.printStackTrace();
            return false;
        }
    }
}
