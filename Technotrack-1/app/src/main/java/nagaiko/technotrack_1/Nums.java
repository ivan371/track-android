package nagaiko.technotrack_1;

/**
 * Created by nagai on 10.10.2017.
 */

public class Nums {
    static String toString(long time) {
        StringBuilder stringBuilder = new StringBuilder();
        time = time % 10000;
        switch ((int) time / 1000) {
            case 1:
                stringBuilder.append("ТЫСЯЧА");
                break;
            default:
                break;
        }
        time %= 1000;
        switch ((int) time / 100) {
            case 1:
                stringBuilder.append("СТО ");
                break;
            case 2:
                stringBuilder.append("ДВЕСТИ ");
                break;
            case 3:
                stringBuilder.append("ТРИСТА ");
                break;
            case 4:
                stringBuilder.append("ЧЕТЫРЕСТА ");
                break;
            case 5:
                stringBuilder.append("ПЯТЬСОТ ");
                break;
            case 6:
                stringBuilder.append("ШЕСТЬСОТ ");
                break;
            case 7:
                stringBuilder.append("СЕМЬСОТ ");
                break;
            case 8:
                stringBuilder.append("ВОСЕМЬСОТ ");
                break;
            case 9:
                stringBuilder.append("ДЕВЯТЬСОТ ");
                break;
            default:
                break;
        }
        time %= 100;
        if (10 <= time && time < 20) {
            switch ((int) time) {
                case 10:
                    stringBuilder.append("ДЕСЯТЬ");
                    break;
                case 11:
                    stringBuilder.append("ОДИННАДЦАТЬ");
                    break;
                case 12:
                    stringBuilder.append("ДВЕНАДЦАТЬ");
                    break;
                case 13:
                    stringBuilder.append("ТРИНАДЦАТЬ");
                    break;
                case 14:
                    stringBuilder.append("ЧЕТЫРНАДЦАТЬ");
                    break;
                case 15:
                    stringBuilder.append("ПЯТНАДЦАТЬ");
                    break;
                case 16:
                    stringBuilder.append("ШЕСТНАДЦАТЬ");
                    break;
                case 17:
                    stringBuilder.append("СЕМНАДЦАТЬ");
                    break;
                case 18:
                    stringBuilder.append("ВОСЕМНАДЦАТЬ");
                    break;
                case 19:
                    stringBuilder.append("ДЕВЯТНАДЦАТЬ");
                    break;
            }
        } else {
            switch ((int) time / 10) {
                case 2:
                    stringBuilder.append("ДВАДЦАТЬ ");
                    break;
                case 3:
                    stringBuilder.append("ТРИДЦАТЬ ");
                    break;
                case 4:
                    stringBuilder.append("СОРОК ");
                    break;
                case 5:
                    stringBuilder.append("ПЯТЬДЕСЯТ ");
                    break;
                case 6:
                    stringBuilder.append("ШЕСТЬДЕСЯТ ");
                    break;
                case 7:
                    stringBuilder.append("СЕМЬДЕСЯТ ");
                    break;
                case 8:
                    stringBuilder.append("ВОСЕМЬДЕСЯТ ");
                    break;
                case 9:
                    stringBuilder.append("ДЕВЯНОСТО ");
                    break;
            }
            time %= 10;
            switch ((int) time) {
                case 1:
                    stringBuilder.append("ОДИН");
                    break;
                case 2:
                    stringBuilder.append("ДВА");
                    break;
                case 3:
                    stringBuilder.append("ТРИ");
                    break;
                case 4:
                    stringBuilder.append("ЧЕТЫРЕ");
                    break;
                case 5:
                    stringBuilder.append("ПЯТЬ");
                    break;
                case 6:
                    stringBuilder.append("ШЕСТЬ");
                    break;
                case 7:
                    stringBuilder.append("СЕМЬ");
                    break;
                case 8:
                    stringBuilder.append("ВОСЕМЬ");
                    break;
                case 9:
                    stringBuilder.append("ДЕВЯТЬ");
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
