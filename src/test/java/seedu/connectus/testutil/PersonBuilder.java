package seedu.connectus.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.connectus.model.person.Address;
import seedu.connectus.model.person.Birthday;
import seedu.connectus.model.person.Email;
import seedu.connectus.model.person.Name;
import seedu.connectus.model.person.Person;
import seedu.connectus.model.person.Phone;
import seedu.connectus.model.socialmedia.SocialMedia;
import seedu.connectus.model.tag.Module;
import seedu.connectus.model.tag.Tag;
import seedu.connectus.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private SocialMedia socialMedia;
    private Set<Tag> tags;
    private Set<Module> modules;
    private Birthday birthday;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        socialMedia = SocialMedia.create();
        tags = new HashSet<>();
        modules = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone().get();
        email = personToCopy.getEmail().get();
        address = personToCopy.getAddress().get();
        socialMedia = personToCopy.getSocialMedia().orElse(SocialMedia.create());
        tags = new HashSet<>(personToCopy.getTags());
        modules = new HashSet<>(personToCopy.getModules());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the
     * {@code Person} that we are building.
     */
    public PersonBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Parses the {@code modules} into a {@code Set<Module>} and set it to the
     * {@code Person} that we are building.
     */
    public PersonBuilder withModules(String... modules) {
        this.modules = SampleDataUtil.getModuleSet(modules);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Birthday} of the {@code Person} that we are building.
     *
     * @return a person with the given details.
     */
    public PersonBuilder withBirthday(String birthday) {
        this.birthday = new Birthday(birthday);
        return this;
    }

    /**
     * Sets the {@code SocialMedia} of the {@code Person} that we are building.
     *
     * @return a person with the given details.
     */
    public PersonBuilder withSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
        return this;
    }

    /**
     * Builds a person with the given details.
     *
     * @return a person with the given details.
     */
    public Person build() {
        Person p = new Person(name, tags, modules);

        if (phone != null) {
            p.setPhone(phone);
        }

        if (email != null) {
            p.setEmail(email);
        }

        if (address != null) {
            p.setAddress(address);
        }

        if (socialMedia != null) {
            p.setSocialMedia(socialMedia);
        }

        if (birthday != null) {
            p.setBirthday(birthday);

        }

        return p;
    }

}