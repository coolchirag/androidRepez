package javax.mail;

import javax.activation.DataSource;

public interface MultipartDataSource extends DataSource {
    BodyPart getBodyPart(int i);

    int getCount();
}
