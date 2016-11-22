package net.slomnicki.aviva.competition;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Clients;
import net.slomnicki.aviva.competition.xml.XmlParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
public class XmlParserTest {

    private XmlParser parser;

    @Before
    public void before() {
        parser = new XmlParser();
    }

    @Test
    public void parseGoodFile() throws Exception {
        // given
        File inputFile = new File(getClass()
                .getClassLoader()
                .getResource("AkademiaWiedzyClients.xml")
                .getFile());

        // when
        Clients clients = parser.readAndParseXmlFile(inputFile);

        // then
        assertEquals(4, clients.getClientList().size());
    }

    @Test(expected = XmlParseException.class)
    public void parseBadFile() throws Exception {
        // given
        File inputFile = new File(getClass()
                .getClassLoader()
                .getResource("AkademiaWiedzyClients-bad.xml")
                .getFile());

        // when
        Clients clients = parser.readAndParseXmlFile(inputFile);

        // then
        // noop
    }

    @Test(expected = XmlParseException.class)
    public void parseNonExistingFile() throws Exception {
        // given
        File inputFile = new File("try.to.find.me");

        // when
        Clients clients = parser.readAndParseXmlFile(inputFile);

        // then
        // noop
    }
}